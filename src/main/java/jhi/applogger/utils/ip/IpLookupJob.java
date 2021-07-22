package jhi.applogger.utils.ip;

import com.google.gson.*;
import jhi.applogger.database.Database;
import jhi.applogger.utils.StringUtils;
import okhttp3.OkHttpClient;
import org.jooq.DSLContext;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static jhi.applogger.database.codegen.tables.Ips.*;

public class IpLookupJob implements Runnable
{
	private static String          ipLookupId;
	private        OkHttpClient    httpClient;
	private        IpLookupService service;

	public static void main(String[] args)
		throws InterruptedException
	{
		Database.init(args[0], args[1], args[2], args[3], args[4]);
		ipLookupId = args[5];

		// Run the job and wait for it to finish
		Thread t = new Thread(new IpLookupJob());
		t.start();
		t.join();
	}

	public static void init(String id)
	{
		ipLookupId = id;
	}

	public IpLookupJob()
	{
		httpClient = new OkHttpClient.Builder()
			.readTimeout(1, TimeUnit.MINUTES)
			.callTimeout(1, TimeUnit.MINUTES)
			.connectTimeout(1, TimeUnit.MINUTES)
			.writeTimeout(1, TimeUnit.MINUTES)
			.retryOnConnectionFailure(true)
			.build();

		Gson gson = new GsonBuilder().disableHtmlEscaping().create();

		Retrofit retrofit = (new Retrofit.Builder()).baseUrl("http://api.ipstack.com/")
													.addConverterFactory(GsonConverterFactory.create(gson))
													.client(httpClient)
													.build();

		service = retrofit.create(IpLookupService.class);
	}

	public void close()
	{
		if (httpClient != null && !httpClient.dispatcher().executorService().isTerminated())
		{
			try
			{
				httpClient.dispatcher().executorService().shutdown();
				httpClient.connectionPool().evictAll();
				httpClient.cache().close();
			}
			catch (Exception e)
			{
				// Ignore exceptions here
			}
		}
	}

	private IpLookupResponse getIpDetails(String ip)
	{
		try
		{
			Call<IpLookupResponse> request = service.getIpDetails(ip, ipLookupId);
			Response<IpLookupResponse> response = request.execute();

			if (response.isSuccessful())
			{
				return response.body();
			}
			else
			{
				if (!StringUtils.isEmpty(response.message()))
					Logger.getLogger("").info(response.message());
				else if (response.errorBody() != null)
					Logger.getLogger("").info(response.errorBody().string());
			}
		}
		catch (IOException e)
		{
			Logger.getLogger("").severe(e.getLocalizedMessage());
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void run()
	{
		Logger.getLogger("").info("RUNNING IP LOOKUP THREAD");

		if (StringUtils.isEmpty(ipLookupId))
		{
			Logger.getLogger("").warning("IP LOOKUP ID NOT SET");
			return;
		}

		try (Connection conn = Database.getConnection())
		{
			DSLContext context = Database.getContext(conn);

			context.selectFrom(IPS)
				   .where(IPS.IP_ADDRESS.isNotNull())
				   .and(IPS.COUNTRY.isNull())
				   .forEach(i -> {
					   IpLookupResponse response = getIpDetails(i.getIpAddress());

					   if (response != null)
					   {
						   i.setCountry(response.getCountry_name());
						   i.setCountryCode(response.getCountry_code());
						   i.setCity(response.getCity());
						   i.setState(response.getRegion_name());
						   i.setLatitude(response.getLatitude() != null ? Double.toString(response.getLatitude()) : null);
						   i.setLongitude(response.getLongitude() != null ? Double.toString(response.getLongitude()) : null);
						   i.store();
					   }
				   });
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger("").severe(e.getMessage());
		}
	}
}
