package de.tum.in.www1.pse.rest.model;

import java.util.Date;

public class Loan {

	private String id;
	private Date startDate;
	private Date endDate;
	private User user;
	
	public Loan(String id, Date startDate, Date endDate, User user) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
