package jhi.applogger.utils;

import javax.xml.bind.annotation.*;

/**
 * POJO for map marker information used in result xml.
 */

@XmlRootElement
public class Marker
{
	private String lat;
	private String lng;
	private String title;

	public Marker()
	{
	}

	@XmlAttribute
	public String getLat()
	{
		return lat;
	}

	public Marker setLat(String lat)
	{
		this.lat = lat;
		return this;
	}

	@XmlAttribute
	public String getLng()
	{
		return lng;
	}

	public Marker setLng(String lng)
	{
		this.lng = lng;
		return this;
	}

	@XmlAttribute
	public String getTitle()
	{
		return title;
	}

	public Marker setTitle(String title)
	{
		this.title = title;
		return this;
	}
}

