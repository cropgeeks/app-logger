package jhi.applogger.resource;

import jhi.applogger.database.Database;
import jhi.applogger.utils.DateParameter;
import org.jooq.*;
import org.jooq.impl.DSL;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.*;
import java.util.logging.Logger;

import static jhi.applogger.database.codegen.tables.Users.*;

// Commented this  out as we don't want to use it yet
//@Path("export/data")
public class DataResource
{
//	@Path("/{applicationId}")
//	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
	public Response getApplicationData(@PathParam("applicationId") Integer applicationId, @QueryParam("startDate") DateParameter startDate, @QueryParam("endDate") DateParameter endDate)
	{
		try
		{
			File result = Files.createTempFile("per-day", "txt").toFile();

			try (Connection conn = Database.getConnection();
				 PrintWriter bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(result), StandardCharsets.UTF_8))))
			{
				DSLContext context = Database.getContext(conn);

				Field<?> theDate = DSL.date(USERS.DATE).as("theDate");
				Field<?> sum = DSL.sum(USERS.RUN_COUNT).as("sum");
				SelectConditionStep<?> step = context.select(
					theDate,
					sum
				)
													 .from(USERS)
													 .where(USERS.APPLICATION_ID.eq(applicationId));

				if (startDate != null)
					step.and(USERS.DATE.ge(startDate.getDate()));
				if (endDate != null)
					step.and(USERS.DATE.le(endDate.getDate()));

				bw.println("date\tsum");

				step
					.groupBy(theDate)
					.orderBy(theDate)
					.forEach(r -> bw.println(r.get(theDate) + "\t" + r.get(sum)));
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				Logger.getLogger("").severe(e.getMessage());
				return null;
			}

			java.nio.file.Path filePath = result.toPath();
			return Response.ok((StreamingOutput) output -> {
				Files.copy(filePath, output);
				Files.deleteIfExists(filePath);
			})
						   .type(MediaType.TEXT_PLAIN_TYPE)
						   .header("content-disposition", "attachment; filename=\"" + result.getName() + "\"")
						   .header("content-length", result.length())
						   .build();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			Logger.getLogger("").severe(e.getMessage());
			return null;
		}
	}
}
