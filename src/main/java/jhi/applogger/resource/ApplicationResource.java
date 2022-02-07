package jhi.applogger.resource;

import jhi.applogger.database.Database;
import jhi.applogger.database.codegen.tables.pojos.Applications;
import org.jooq.DSLContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

import static jhi.applogger.database.codegen.tables.Applications.*;

@Path("export/application")
public class ApplicationResource
{
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Applications> getApplications()
	{
		try (Connection conn = Database.getConnection())
		{
			DSLContext context = Database.getContext(conn);

			return context.selectFrom(APPLICATIONS)
						  .orderBy(APPLICATIONS.APP_NAME)
						  .fetchInto(Applications.class);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger("").severe(e.getMessage());
			return null;
		}
	}
}
