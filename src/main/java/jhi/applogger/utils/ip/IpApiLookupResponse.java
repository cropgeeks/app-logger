package jhi.applogger.utils.ip;

public class IpApiLookupResponse
{
	private String country;
	private String countryCode;
	private String region;
	private String regionName;
	private String City;
	private String zip;
	private Double lat;
	private Double lon;
	private String timezone;
	private String isp;
	private String org;
	private String as;

	public IpApiLookupResponse()
	{
	}

	public String getCountry()
	{
		return country;
	}

	public IpApiLookupResponse setCountry(String country)
	{
		this.country = country;
		return this;
	}

	public String getCountryCode()
	{
		return countryCode;
	}

	public IpApiLookupResponse setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
		return this;
	}

	public String getRegion()
	{
		return region;
	}

	public IpApiLookupResponse setRegion(String region)
	{
		this.region = region;
		return this;
	}

	public String getRegionName()
	{
		return regionName;
	}

	public IpApiLookupResponse setRegionName(String regionName)
	{
		this.regionName = regionName;
		return this;
	}

	public String getCity()
	{
		return City;
	}

	public IpApiLookupResponse setCity(String city)
	{
		City = city;
		return this;
	}

	public String getZip()
	{
		return zip;
	}

	public IpApiLookupResponse setZip(String zip)
	{
		this.zip = zip;
		return this;
	}

	public Double getLat()
	{
		return lat;
	}

	public IpApiLookupResponse setLat(Double lat)
	{
		this.lat = lat;
		return this;
	}

	public Double getLon()
	{
		return lon;
	}

	public IpApiLookupResponse setLon(Double lon)
	{
		this.lon = lon;
		return this;
	}

	public String getTimezone()
	{
		return timezone;
	}

	public IpApiLookupResponse setTimezone(String timezone)
	{
		this.timezone = timezone;
		return this;
	}

	public String getIsp()
	{
		return isp;
	}

	public IpApiLookupResponse setIsp(String isp)
	{
		this.isp = isp;
		return this;
	}

	public String getOrg()
	{
		return org;
	}

	public IpApiLookupResponse setOrg(String org)
	{
		this.org = org;
		return this;
	}

	public String getAs()
	{
		return as;
	}

	public IpApiLookupResponse setAs(String as)
	{
		this.as = as;
		return this;
	}
}
