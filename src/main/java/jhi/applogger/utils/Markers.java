package jhi.applogger.utils;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "markers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Markers
{
	@XmlElement(name = "marker")
	private List<Marker> markers = null;

	public List<Marker> getMarkers()
	{
		return markers;
	}

	public void setMarkers(List<Marker> markers)
	{
		this.markers = markers;
	}
}