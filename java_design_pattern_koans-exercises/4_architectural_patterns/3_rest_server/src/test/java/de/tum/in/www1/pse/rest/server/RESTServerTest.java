package de.tum.in.www1.pse.rest.server;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.tum.in.www1.pse.rest.model.Book;
import de.tum.in.www1.pse.rest.model.Loan;
import de.tum.in.www1.pse.rest.model.User;

public class RESTServerTest {

	@Before
	public void setup() throws InterruptedException {
		RESTServer.main(null);
		//sleep some time so that the server gets initiated properly
		Thread.sleep(500);
	}
	
	@Test(timeout = 3000)
	public void testGetBooks() throws IOException {
		URL url = new URL("http://localhost:4567/books");
		URLConnection connection = url.openConnection();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		Collection<String> bookIds = ModelStorage.getBooks().keySet();
		String expectedResponse = "[\"" + String.join("\",\"", bookIds) + "\"]";
		System.out.println("Expected response: " + expectedResponse);
		
		String inputLine;
		while ((inputLine = bufferedReader.readLine()) != null) {
			System.out.println("Actual response: " + inputLine);
			assertTrue("Get request for books not implemented properly", inputLine.equals(expectedResponse));
		}
		bufferedReader.close();
	}
	
	@Test(timeout = 3000)
	public void testPostLoan() throws IOException, UnirestException, InterruptedException {
		Gson gson = new GsonBuilder().create();
		Book book = ModelStorage.getBooks().values().iterator().next();
		int numberOfLoans = book.getLoans().size();
		book.setAmount(numberOfLoans + 1);

		System.out.println("Book: " + gson.toJson(book));
		User user = ModelStorage.getUsers().values().iterator().next();
		Loan loan = new Loan(null, null, null, user);
		
		String loanJson = gson.toJson(loan);
		System.out.println("Loan json: " + loanJson);
		String postLoanUrl = "http://localhost:4567/books/" + book.getId() + "/loans";
		System.out.println("POST URL: " + postLoanUrl);
		try {
			HttpResponse<JsonNode> response = Unirest.post(postLoanUrl).body(loanJson).asJson();
			System.out.println("Response " + response.getBody().toString() + ", statusCode " + response.getStatus());
			assertTrue("POST loans not implemented", response.getStatus() == 201);
			assertTrue("Number of loans after POST request is wrong", book.getLoans().size() == numberOfLoans + 1);
		}
		catch(UnirestException ex) {
			throw new RuntimeException("POST loans not implemented correctly");
		}
				
		HttpResponse<String> response2 = Unirest.post(postLoanUrl).body(loanJson).asString();
		System.out.println("Response " + response2.getBody().toString() + ", statusCode " + response2.getStatus());
		assertTrue("Too many POST loans are possible. Logic for rejecting loans missing if a book is not available.", response2.getStatus() == 403);
		assertTrue("Number of loans after POST request is wrong", book.getLoans().size() == numberOfLoans + 1);
	}
	
	@Test(timeout = 3000)
	public void testDeleteLoan() throws IOException, UnirestException, InterruptedException {
		Gson gson = new GsonBuilder().create();
		User user = ModelStorage.getUsers().values().iterator().next();
		Book book = ModelStorage.getBooks().values().iterator().next();
		System.out.println("Book: " + gson.toJson(book));

		int numberOfLoans = book.getLoans().size();
		Loan loanToDelete = null;
		
		//Make sure that at least one loan exists
		if(numberOfLoans < 1) {
			book.setAmount(3);	//make sure we have enough books to loan
			Loan newLoan = new Loan(null, null, null, user);
			String postLoanUrl = "http://localhost:4567/books/" + book.getId() + "/loans";
			String loanJson = gson.toJson(newLoan);
			HttpResponse<JsonNode> response = Unirest.post(postLoanUrl).body(loanJson).asJson();
			assertTrue("POST loans not implemented correctly", response.getStatus() == 201);
			numberOfLoans = book.getLoans().size();
		}
		
		loanToDelete = book.getLoans().get(0);		
		
		String deleteLoanUrl = "http://localhost:4567/books/" + book.getId() + "/loans/" + loanToDelete.getId();
		System.out.println("DELETE URL: " + deleteLoanUrl);
		HttpResponse<String> response = Unirest.delete(deleteLoanUrl).asString();
		System.out.println("Response " + response.getBody().toString() + ", statusCode " + response.getStatus());
		assertTrue("DELETE loans not implemented", response.getStatus() == 200);
		assertTrue("Number of loans after POST request is wrong", book.getLoans().size() == numberOfLoans - 1);		
	}
}
