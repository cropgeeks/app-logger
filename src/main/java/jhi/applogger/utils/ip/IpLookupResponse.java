package jhi.applogger.utils.ip;

public class IpLookupResponse
{
	private String city;
	private String country_code;
	private String country_name;
	private String ip;
	private Double latitude;
	private Double longitude;
	private String metro_code;
	private String region_code;
	private String region_name;
	private String zip_code;

	public IpLookupResponse()
	{
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry_code()
	{
		return country_code;
	}

	public void setCountry_code(String country_code)
	{
		this.country_code = country_code;
	}

	public String getCountry_name()
	{
		return country_name;
	}

	public void setCountry_name(String country_name)
	{
		this.country_name = country_name;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public Double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	public String getMetro_code()
	{
		return metro_code;
	}

	public void setMetro_code(String metro_code)
	{
		this.metro_code = metro_code;
	}

	public String getRegion_code()
	{
		return region_code;
	}

	public void setRegion_code(String region_code)
	{
		this.region_code = region_code;
	}

	public String getRegion_name()
	{
		return region_name;
	}

	public void setRegion_name(String region_name)
	{
		this.region_name = region_name;
	}

	public String getZip_code()
	{
		return zip_code;
	}

	public void setZip_code(String zip_code)
	{
		this.zip_code = zip_code;
	}
}
