/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


// @formatter:off
/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Ips implements Serializable {

    private static final long serialVersionUID = 1861422201;

    private Integer id;
    private String  ipAddress;
    private String  country;
    private String  countryCode;
    private String  city;
    private String  latitude;
    private String  longitude;
    private String  hostname;
    private String  provider;
    private String  state;

    public Ips() {}

    public Ips(Ips value) {
        this.id = value.id;
        this.ipAddress = value.ipAddress;
        this.country = value.country;
        this.countryCode = value.countryCode;
        this.city = value.city;
        this.latitude = value.latitude;
        this.longitude = value.longitude;
        this.hostname = value.hostname;
        this.provider = value.provider;
        this.state = value.state;
    }

    public Ips(
        Integer id,
        String  ipAddress,
        String  country,
        String  countryCode,
        String  city,
        String  latitude,
        String  longitude,
        String  hostname,
        String  provider,
        String  state
    ) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.country = country;
        this.countryCode = countryCode;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hostname = hostname;
        this.provider = provider;
        this.state = state;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ips (");

        sb.append(id);
        sb.append(", ").append(ipAddress);
        sb.append(", ").append(country);
        sb.append(", ").append(countryCode);
        sb.append(", ").append(city);
        sb.append(", ").append(latitude);
        sb.append(", ").append(longitude);
        sb.append(", ").append(hostname);
        sb.append(", ").append(provider);
        sb.append(", ").append(state);

        sb.append(")");
        return sb.toString();
    }
// @formatter:on
}
