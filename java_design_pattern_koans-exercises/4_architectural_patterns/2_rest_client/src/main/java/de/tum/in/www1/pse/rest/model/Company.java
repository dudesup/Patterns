package de.tum.in.www1.pse.rest.model;

import org.json.JSONObject;

public class Company {
	
	private String name;
	private String catchPhrase;
	private String bs;
	
	public Company(String name, String catchPhrase, String bs) {
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}
	
	public Company(JSONObject companyJson) {
		this.name = companyJson.getString("name");
		this.catchPhrase = companyJson.getString("catchPhrase");
		this.bs = companyJson.getString("bs");
	}
	
	public JSONObject toJson() {
		JSONObject companyJson = new JSONObject();
		companyJson.put("name", name);
		companyJson.put("catchPhrase", catchPhrase);
		companyJson.put("bs", bs);
		return companyJson;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatchPhrase() {
		return catchPhrase;
	}
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
}
