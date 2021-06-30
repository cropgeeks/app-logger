package jhi.applogger;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class AppLogger extends ResourceConfig
{
	public AppLogger()
	{
		packages("jhi.apptracker.resource");
	}
}
