package de.tum.in.www1.pse.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private String id;
	private String author;
	private String title;
	private Integer amount;
	private List<Loan> loans = new ArrayList<Loan>();

    public Book(String id, String author, String title, Integer amount) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.amount = amount;
	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}
	
	public void removeLoan(Loan loan) {
		this.loans.remove(loan);
	}

}
