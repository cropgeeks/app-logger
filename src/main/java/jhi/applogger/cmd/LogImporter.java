package jhi.applogger.cmd;

import jhi.applogger.database.Database;
import jhi.applogger.database.codegen.tables.records.ApplicationsRecord;
import jhi.applogger.resource.LoggerResource;
import org.jooq.DSLContext;

import java.io.*;
import java.sql.*;

import static jhi.applogger.database.codegen.tables.Applications.*;

public class LogImporter
{
	public static void main(String[] args)
		throws SQLException, IOException
	{
		// Initialise the database
		Database.init(args[0], args[1], args[2], args[3], args[4]);
		// Get the application name
		String application = args[5];

		File input = new File(args[6]);

		try (Connection conn = Database.getConnection())
		{
			DSLContext context = Database.getContext(conn);

			ApplicationsRecord app = context.selectFrom(APPLICATIONS)
											.where(APPLICATIONS.APP_NAME.eq(application))
											.fetchAny();

			LoggerResource.addEntries(context, app, input);
		}
	}
}
