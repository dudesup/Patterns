package de.tum.in.www1.pse.rest.model;

import org.json.JSONObject;

public class GeoLocation {
	private Double longitude;
	private Double latitude;
	
	public GeoLocation(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public GeoLocation(JSONObject geoJson) {
		//TODO: implement deserialization from JSON to GeoLocation object
	}
	
	public JSONObject toJson() {
		JSONObject geoJson = new JSONObject();
		//TODO: implement serialization from GeoLocation object to JSON
		return geoJson;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
