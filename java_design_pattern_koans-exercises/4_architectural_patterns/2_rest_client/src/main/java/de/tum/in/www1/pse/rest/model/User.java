package de.tum.in.www1.pse.rest.model;

import org.json.JSONObject;

public class User {
	
	private Integer id;
	private String name;
	private String username;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
		
	public User(Integer id, String name, String username, String email, Address address, String phone, String website,
			Company company) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}
	
	public User(JSONObject userJson) {
		this.id = userJson.getInt("id");
		this.name = userJson.getString("name");
		this.username = userJson.getString("username");
		this.email = userJson.getString("email");
		
		JSONObject addressJson = userJson.getJSONObject("address");
		this.address = new Address(addressJson);
		this.phone = userJson.getString("phone");
		this.website = userJson.getString("website");

		JSONObject companyJson = userJson.getJSONObject("company");
		this.company = new Company(companyJson);
	}
	
	public JSONObject toJson() {
		JSONObject userJson = new JSONObject();
		userJson.put("id", id);
		userJson.put("name", name);
		userJson.put("username", username);
		userJson.put("email", email);
		if (address != null) {
			userJson.put("address", address.toJson());
		}
		userJson.put("phone", phone);
		userJson.put("website", website);
		if (company != null) {
			userJson.put("company", company.toJson());
		}
		
		return userJson;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

}
