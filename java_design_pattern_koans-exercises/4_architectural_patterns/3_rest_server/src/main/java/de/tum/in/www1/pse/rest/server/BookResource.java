package de.tum.in.www1.pse.rest.server;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.tum.in.www1.pse.rest.model.Book;
import de.tum.in.www1.pse.rest.model.Loan;

public class BookResource {

	public static void startResource() {

		System.out.println("BookResource started");
		// Get all available books (ids)
		get("/books", "application/json", (request, response) -> {
			return ModelStorage.getBooks().keySet();
		}, new JsonTransformer());

		// Get one book for the provided id
		get("/books/:id", (request, response) -> {
			String id = request.params(":id");
			Book book = ModelStorage.getBooks().get(id);
			if (book != null) {
				return book;
			} else {
				response.status(404); // 404 Not found
				return "Book with id " + id + " not found";
			}
		}, new JsonTransformer());

		// Create a new book
		post("/books", (request, response) -> {
			Gson gson = new GsonBuilder().create();
			System.out.println(request.body());
			Book newBook = gson.fromJson(request.body(), Book.class);
			String id = ModelStorage.createRandomId();
			ModelStorage.getBooks().put(id, newBook);
			newBook.setId(id);
			response.status(201); // 201 Created
			return newBook;
			//please be careful: this book is not yet stored in a library
		}, new JsonTransformer());

		// Update the book for the provided id with new information
		put("/books/:id", (request, response) -> {
			String id = request.params(":id");
			Gson gson = new GsonBuilder().create();
			Book updatedBook = gson.fromJson(request.body(), Book.class);
			Book originalBook = ModelStorage.getBooks().get(id);

			//to simplify this case, we only update the attributes and not the references
			if (originalBook != null) {
				originalBook.setAuthor(updatedBook.getAuthor());
				originalBook.setTitle(updatedBook.getTitle());
				originalBook.setAmount(updatedBook.getAmount());

				return originalBook;
			} else {
				response.status(404); // 404 Not found
				return "Book with id " + id + " not found";
			}
		}, new JsonTransformer());

		// Delete the book for the provided id
		delete("/books/:id", (request, response) -> {
			String id = request.params(":id");
			Book book = ModelStorage.getBooks().remove(id);
			if (book != null) {
				response.status(200);
				return "Book with id " + id + " deleted";
			} else {
				response.status(404); // 404 Not found
				return "Book with id " + id + " not found";
			}
		});



		///***** Loan requests ***** ///

		// Get all loans of one book for the provided id
		get("/books/:id/loans", (request, response) -> {
			String id = request.params(":id");
			Book book = ModelStorage.getBooks().get(id);
			if (book != null) {
				List<String> loanIds = new ArrayList<String>();
				for (Loan loan : book.getLoans()) {
					loanIds.add(loan.getId());
				}
				return loanIds;
			} else {
				response.status(404); // 404 Not found
				return "Book with id " + id + " not found";
			}
		}, new JsonTransformer());

		// Get one loan of one book for the provided id
		get("/books/:bookId/loans/:loanId", (request, response) -> {
			String bookId = request.params(":bookId");
			Book book = ModelStorage.getBooks().get(bookId);
			if (book != null) {
				String loanId = request.params(":loanId");
				for(Loan loan : book.getLoans()) {
					if (loan.getId().equals(loanId)) {
						return loan;
					}
				}
				response.status(404); // 404 Not found
				return "Loan with id " + loanId + " not found";
			} else {
				response.status(404); // 404 Not found
				return "Book with id " + bookId + " not found";
			}
		}, new JsonTransformer());

		//TODO: implement POST loan request

		//TODO: implement DELETE loan request 
	}
}
