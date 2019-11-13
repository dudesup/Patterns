package de.tum.in.www1.pse.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private String id;
	private String name;
	private List<Book> books = new ArrayList<Book>();
	
	public Library(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	public void removeBook(Book book) {
		this.books.remove(book);
	}
}
