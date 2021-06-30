package jhi.applogger.database;

import jhi.applogger.database.codegen.ApptrackerDb;
import jhi.applogger.utils.StringUtils;
import org.jooq.*;
import org.jooq.conf.*;
import org.jooq.impl.DSL;

import java.sql.*;
import java.util.TimeZone;
import java.util.logging.Logger;

/**
 * @author Sebastian Raubach
 */
public class Database
{
	private static String databaseServer;
	private static String databaseName;
	private static String databasePort;
	private static String username;
	private static String password;

	private static final String utc = TimeZone.getDefault().getID();

	public static void init(String databaseServer, String databaseName, String databasePort, String username, String password)
	{
		Database.databaseServer = databaseServer;
		Database.databaseName = databaseName;
		Database.databasePort = databasePort;
		Database.username = username;
		Database.password = password;

		try
		{
			// The newInstance() call is a work around for some
			// broken Java implementations
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		}
		catch (Exception ex)
		{
			// handle the error
		}

		// Get an initial connection to try if it works. Attempt a connection 10 times before failing
		boolean connectionSuccessful = false;
		for (int attempt = 0; attempt < 10; attempt++)
		{
			try (Connection conn = getDirectConnection())
			{
				Database.getContext(conn);
				connectionSuccessful = true;
				break;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				Logger.getLogger("").severe(e.getLocalizedMessage());

				// If the attempt fails, wait 5 seconds before the next one
				try
				{
					Thread.sleep(5000);
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}

		if (!connectionSuccessful)
			throw new RuntimeException("Unable to connect to database after 10 attempts. Exiting.");
	}

	private static String getDatabaseUrl()
	{
		return "jdbc:mysql://" + databaseServer + ":" + (StringUtils.isEmptyOrQuotes(databasePort) ? "3306" : databasePort) + "/" + databaseName + "?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=" + utc;
	}

	public static Connection getConnection()
		throws SQLException
	{
		return DriverManager.getConnection(getDatabaseUrl(), username, password);
	}

	private static Connection getDirectConnection()
		throws SQLException
	{
		return DriverManager.getConnection(getDatabaseUrl(), username, password);
	}

	public static DSLContext getContext(Connection connection)
	{
		Settings settings = new Settings()
			.withRenderMapping(new RenderMapping()
				.withSchemata(
					new MappedSchema().withInput(ApptrackerDb.APPTRACKER_DB.getQualifiedName().first())
									  .withOutput(databaseName)));

		return DSL.using(connection, SQLDialect.MYSQL, settings);
	}
}