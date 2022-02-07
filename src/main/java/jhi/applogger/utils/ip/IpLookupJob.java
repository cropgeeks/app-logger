package jhi.applogger.utils.ip;

import com.google.gson.*;
import jhi.applogger.database.Database;
import jhi.applogger.database.codegen.tables.records.IpsRecord;
import jhi.applogger.utils.StringUtils;
import okhttp3.OkHttpClient;
import org.jooq.*;
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
//		ipLookupId = args[5];

		// Run the job and wait for it to finish
		Thread t = new Thread(new IpLookupJob());
		t.start();
		t.join();
	}

//	public static void init(String id)
//	{
//		ipLookupId = id;
//	}

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

		Retrofit retrofit = (new Retrofit.Builder()).baseUrl("http://ip-api.com/")
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

	private IpApiLookupResponse getIpDetails(String ip)
	{
		try
		{
			Call<IpApiLookupResponse> request = service.getIpDetails(ip);
			Response<IpApiLookupResponse> response = request.execute();

			if (response.code() == 104)
			{
				// Limit reached
				throw new RuntimeException();
			}
			else if (response.isSuccessful())
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

			Cursor<IpsRecord> result = context.selectFrom(IPS)
											  .where(IPS.IP_ADDRESS.isNotNull())
											  .and(IPS.COUNTRY.isNull())
											  .fetchLazy();

			boolean goOn = true;
			while (goOn && result.hasNext())
			{
				IpsRecord r = result.fetchNext();
				try
				{
					IpApiLookupResponse response = getIpDetails(r.getIpAddress());

					if (response != null)
					{
						r.setCountry(response.getCountry());
						r.setCountryCode(response.getCountryCode());
						r.setCity(response.getCity());
						r.setState(response.getRegionName());
						r.setLatitude(response.getLat() != null ? Double.toString(response.getLat()) : null);
						r.setLongitude(response.getLon() != null ? Double.toString(response.getLon()) : null);
						r.store();
					}
				}
				catch (Exception e)
				{
					goOn = false;
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger("").severe(e.getMessage());
		}
	}
}
