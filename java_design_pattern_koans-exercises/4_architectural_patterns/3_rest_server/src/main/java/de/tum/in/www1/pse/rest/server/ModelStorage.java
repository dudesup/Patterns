package de.tum.in.www1.pse.rest.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.tum.in.www1.pse.rest.model.Book;
import de.tum.in.www1.pse.rest.model.Library;
import de.tum.in.www1.pse.rest.model.Loan;
import de.tum.in.www1.pse.rest.model.User;

public class ModelStorage {
	/**
     * Maps holding the books and the libraries
     */
    private static Map<String, Book> books = new HashMap<String, Book>();
    private static Map<String, Library> libraries = new HashMap<String, Library>();
    private static Map<String, User> users = new HashMap<String, User>();
    
    private static Random random = new Random();
    
    public static void createSampleModel() {
    	Library library1 = new Library(createRandomId(), "Technische Universität München");
    	
    	Book book1 = new Book(createRandomId(), "Bernd Bruegge", "Object Oriented Software Engineering", 2);
    	Book book2 = new Book(createRandomId(), "Frank Buschmann", "Pattern-Oriented Software Architecture Volume 1: A System of Patterns", 5);

    	library1.addBook(book1);
    	library1.addBook(book2);
    	
    	User user1 = new User(createRandomId(), "Stephan Krusche");
    	User user2 = new User(createRandomId(), "Andreas Seitz");
    	users.put(user1.getId(), user1);
    	users.put(user2.getId(), user2);
    	
    	Loan loan1 = new Loan(createRandomId(), null, null, user1);
    	Loan loan2 = new Loan(createRandomId(), null, null, user2);

    	book1.addLoan(loan1);
    	book2.addLoan(loan2);
    	
    	books.put(book1.getId(), book1);
    	books.put(book2.getId(), book2);
    	
    	libraries.put(library1.getId(), library1);
    }
    
    public static Map<String, Book> getBooks() {
    	return books;
    }
    
    public static Map<String, Library> getLibraries() {
    	return libraries;
    }
    
    public static Map<String, User> getUsers() {
    	return users;
    }
    
    public static String createRandomId() {
    	return String.valueOf(random.nextInt(Integer.MAX_VALUE));
    }
    
}
