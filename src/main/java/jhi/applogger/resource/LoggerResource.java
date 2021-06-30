package jhi.applogger.resource;

import jhi.applogger.database.Database;
import jhi.applogger.database.codegen.tables.records.*;
import jhi.applogger.utils.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static jhi.applogger.database.codegen.tables.Applications.*;
import static jhi.applogger.database.codegen.tables.Ips.*;
import static jhi.applogger.database.codegen.tables.Users.*;
import static jhi.applogger.database.codegen.tables.UsersIps.*;

@Path("log")
public class LoggerResource
{
	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private String getIp()
	{
		String xForwardedForIP = request.getHeader("X-Forwarded-For");

		if (!StringUtils.isEmpty(xForwardedForIP))
			return new StringTokenizer(xForwardedForIP, ",").nextToken().trim();
		else
			return request.getRemoteAddr();
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public void postLogger(@QueryParam("application") String application)
		throws IOException
	{
		try (Connection conn = Database.getConnection())
		{
			DSLContext context = Database.getContext(conn);
			ApplicationsRecord app = context.selectFrom(APPLICATIONS)
											.where(APPLICATIONS.APP_NAME.eq(application))
											.fetchAny();

			// Check if app name is set
			if (app == null)
			{
				response.sendError(Response.Status.BAD_REQUEST.getStatusCode());
				return;
			}

			// Receive the file upload
			ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
			try
			{
				List<FileItem> items = fileUpload.parseRequest(request);

				// Store in temp
				File file = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString() + ".log");
				if (items != null)
				{
					for (FileItem item : items)
					{
						if (!item.isFormField() && Objects.equals(item.getFieldName(), "logfile"))
							item.write(file);
					}
				}

				// Parse the date timestamp
				SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");

				// For each line, import it individually
				Files.readAllLines(file.toPath())
					 .forEach(l -> {
						 // Split into entries
						 String[] split = l.split("\t", -1);

						 // There should be 8
						 if (split.length != 8)
							 return;

						 Integer rating = null;
						 Timestamp date = null;
						 try
						 {
							 // Parse the rating
							 rating = Integer.parseInt(split[5]);
						 }
						 catch (Exception e)
						 {
						 }
						 try
						 {
							 // Parse the date
							 date = new Timestamp(sdf.parse(split[0]).getTime());
						 }
						 catch (Exception e)
						 {
						 }
						 try
						 {
							 // Insert the row
							 addEntry(context, application, split[2], split[1], split[7], split[3], split[4], split[6], rating, date);
						 }
						 catch (IOException e)
						 {
						 }
					 });

				// Delete the file
				file.delete();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger("").severe(e.getMessage());
		}
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void getLogger(@QueryParam("application") String application,
						   @QueryParam("id") String userId,
						   @QueryParam("ip") String ip,
						   @QueryParam("version") String version,
						   @QueryParam("locale") String locale,
						   @QueryParam("os") String os,
						   @QueryParam("user") String userName,
						   @QueryParam("rating") Integer rating)
		throws IOException
	{
		try (Connection conn = Database.getConnection())
		{
			DSLContext context = Database.getContext(conn);
			addEntry(context, application, userId, ip, userName, version, locale, os, rating, new Timestamp(System.currentTimeMillis()));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger("").severe(e.getMessage());
		}
	}

	@GET
	@Path("/xml")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public List<Marker> getMarkersXml(@QueryParam("application") String application)
		throws IOException
	{
		if (StringUtils.isEmpty(application))
		{
			response.sendError(Response.Status.BAD_REQUEST.getStatusCode());
			return null;
		}

		try (Connection conn = Database.getConnection())
		{
			DSLContext context = Database.getContext(conn);

			// Get the information from the database
			return context.selectDistinct(
				IPS.LATITUDE,
				IPS.LONGITUDE,
				IPS.CITY,
				IPS.COUNTRY
			)
						  .from(IPS.leftJoin(USERS_IPS).on(IPS.ID.eq(USERS_IPS.IPS_ID))
								   .leftJoin(APPLICATIONS).on(APPLICATIONS.ID.eq(USERS_IPS.APPLICATIONS_ID)))
						  .where(APPLICATIONS.APP_NAME.eq(application))
						  // Stream results directly and map them into POJOs
						  .stream()
						  .map(i -> new Marker()
							  .setLat(i.get(IPS.LATITUDE))
							  .setLng(i.get(IPS.LONGITUDE))
							  // Join city and country together
							  .setTitle(StringUtils.join(", ", "n/a", i.get(IPS.CITY), i.get(IPS.COUNTRY)))
						  )
						  .collect(Collectors.toList());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger("").severe(e.getMessage());
		}

		return null;
	}

	private void addEntry(DSLContext context, String application, String userId, String ip, String userName, String version, String locale, String os, Integer rating, Timestamp date)
		throws IOException
	{
		// Ignore X.XX.XX.XX and X.XX.XX versions
		if (Objects.equals(version, "X.XX.XX.XX") || Objects.equals(version, "X.XX.XX"))
			return;

		// Get the IP from the request if none is provided
		if (StringUtils.isEmpty(ip))
			ip = getIp();

		ApplicationsRecord app = context.selectFrom(APPLICATIONS)
										.where(APPLICATIONS.APP_NAME.eq(application))
										.fetchAny();

		// Check if app name and user id are set
		if (app == null || StringUtils.isEmpty(userId))
		{
			response.sendError(Response.Status.BAD_REQUEST.getStatusCode());
			return;
		}

		// Get the user record
		UsersRecord user = context.selectFrom(USERS)
								  .where(USERS.APPLICATION_ID.eq(app.getId()).and(USERS.USERID.eq(userId)))
								  .fetchAny();

		if (user != null)
		{
			// Update the user record
			user.setRunCount(user.getRunCount().add(1));
			if (!StringUtils.isEmpty(version))
				user.setVersion(version);
			if (!StringUtils.isEmpty(locale))
				user.setLocale(locale);
			if (!StringUtils.isEmpty(os))
				user.setOs(os);

			if (rating != null)
			{
				UInteger uRating = UInteger.valueOf(rating);
				// If one exists already, take the maximum
				if (user.getRating() != null)
				{
					int comparison = user.getRating().compareTo(UInteger.valueOf(rating));

					if (comparison < 0)
						user.setRating(uRating);
				}
				else
				{
					user.setRating(uRating);
				}

			}
			user.store();
		}
		else
		{
			// Create a new user record
			user = context.newRecord(USERS);
			user.setApplicationId(app.getId());
			user.setUserid(userId);
			user.setUserName(userName);
			user.setVersion(version);
			user.setLocale(locale);
			user.setDate(date);
			user.setOs(os);
			user.setRunCount(UInteger.valueOf(1));
			if (rating != null)
				user.setRating(UInteger.valueOf(rating));
			user.store();
		}

		// Get the ip record
		IpsRecord ipRecord = context.selectFrom(IPS)
									.where(IPS.IP_ADDRESS.eq(ip))
									.fetchAny();

		if (ipRecord == null)
		{
			// Create a new ip record
			ipRecord = context.newRecord(IPS);
			ipRecord.setIpAddress(ip);
			ipRecord.store();
		}

		// Look up the unique mapping between user, application and ip
		UsersIpsRecord userIp = context.selectFrom(USERS_IPS)
									   .where(USERS_IPS.USERS_ID.eq(user.getId()))
									   .and(USERS_IPS.APPLICATIONS_ID.eq(app.getId()))
									   .and(USERS_IPS.IPS_ID.eq(ipRecord.getId()))
									   .fetchAny();

		if (userIp == null)
		{
			// Create it if it doesn't exist
			userIp = context.newRecord(USERS_IPS);
			userIp.setUsersId(user.getId());
			userIp.setIpsId(ipRecord.getId());
			userIp.setApplicationsId(app.getId());
			userIp.store();
		}
	}
}