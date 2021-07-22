package jhi.applogger.cmd;

import jhi.applogger.database.Database;
import jhi.applogger.resource.LoggerResource;
import jhi.applogger.utils.Markers;

import javax.xml.bind.*;
import java.io.File;

public class XmlGenerator
{
	public static void main(String[] args)
		throws JAXBException
	{
		// Initialise the database
		Database.init(args[0], args[1], args[2], args[3], args[4]);
		// Get the application name
		String application = args[5];
		// Get the target file
		File target = new File(args[6]);

		// Get the markers, then serialize them into a file.
		Markers markers = LoggerResource.getMarkers(application);
		JAXBContext jaxbContext = JAXBContext.newInstance(Markers.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(markers, target);
	}
}
