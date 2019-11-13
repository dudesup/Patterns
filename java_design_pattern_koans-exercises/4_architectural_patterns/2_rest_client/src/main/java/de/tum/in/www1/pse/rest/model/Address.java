package de.tum.in.www1.pse.rest.model;

import org.json.JSONObject;

public class Address {
	
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private GeoLocation geoLocation;
	
	public Address(String street, String suite, String city, String zipcode, GeoLocation geoLocation) {
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.geoLocation = geoLocation;
	}
	
	public Address(JSONObject addressJson) {
		//TODO: implement deserialization from JSON to Address object
	}
	
	public JSONObject toJson() {
		JSONObject addressJson = new JSONObject();
		//TODO: implement serialization from Address object to JSON
		return addressJson;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
}
