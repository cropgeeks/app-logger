package jhi.applogger.utils;

import com.thetransactioncompany.cors.*;
import jhi.applogger.utils.ip.IpLookupJob;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.Properties;
import java.util.concurrent.*;

@WebListener
public class ApplicationListener implements ServletContextListener
{
	private static ScheduledExecutorService backgroundScheduler;

	private static IpLookupJob ipLookupJob;

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		try
		{
			// Configure the CORS filter
			Properties props = new Properties();
			props.setProperty("cors.supportedMethods", "GET, POST, HEAD, OPTIONS, PUT");
			final FilterRegistration.Dynamic corsFilter = sce.getServletContext().addFilter("CORS", new CORSFilter(new CORSConfiguration(props)));
			corsFilter.setInitParameter("cors.supportedMethods", "GET, POST, HEAD, OPTIONS, PUT");
			corsFilter.addMappingForUrlPatterns(null, false, "/*");
		}
		catch (CORSConfigurationException e)
		{
			e.printStackTrace();
		}

		// Initialize the property watcher
		PropertyWatcher.initialize();

		// Run the IP lookup job every day
		ipLookupJob = new IpLookupJob();
		backgroundScheduler = Executors.newSingleThreadScheduledExecutor();
		backgroundScheduler.scheduleAtFixedRate(ipLookupJob, 0, 1, TimeUnit.DAYS);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent)
	{
		// Remember to stop watching and close the HTTP client in the IP lookup
		PropertyWatcher.stopFileWatcher();
		ipLookupJob.close();

		try
		{
			// Stop the scheduler
			if (backgroundScheduler != null)
				backgroundScheduler.shutdownNow();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
