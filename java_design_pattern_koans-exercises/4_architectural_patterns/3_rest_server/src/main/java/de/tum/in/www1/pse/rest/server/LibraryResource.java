package de.tum.in.www1.pse.rest.server;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.List;

import de.tum.in.www1.pse.rest.model.Book;
import de.tum.in.www1.pse.rest.model.Library;

public class LibraryResource {

	public static void startResource() {	
        
        // Get all available libraries
        get("/libraries", "application/json", (request, response) -> {
            return ModelStorage.getLibraries().keySet();
        }, new JsonTransformer());
        
        // Get one specific library
        get("/libraries/:libraryId",  (request, response) -> {
        	String libraryId = request.params(":libraryId");
        	Library library = ModelStorage.getLibraries().get(libraryId);
        	if (library != null) {
        		return library;
        	}
        	else {
                response.status(404); // 404 Not found
                return "Library with id " + libraryId + " not found";
        	}
        }, new JsonTransformer());
        
		// Gets all the books in one library
        get("/libraries/:id/books",  (request, response) -> {
        	String libraryId = request.params(":libraryId");
        	Library library = ModelStorage.getLibraries().get(libraryId);
        	if (library != null) {
        		List<String> bookIds = new ArrayList<String>();
        		for(Book book : library.getBooks()) {
        			bookIds.add(book.getId());
        		}
        		return bookIds;
        	}
        	else {
                response.status(404); // 404 Not found
                return "Library with id " + libraryId + " not found";
        	}
        }, new JsonTransformer());
        
        get("/libraries/:libraryId/books/:bookId", (request, response) -> {
        	String libraryId = request.params(":libraryId");
        	Library library = ModelStorage.getLibraries().get(libraryId);
        	if (library != null) {
        		response.redirect("/books/" + request.params(":bookId"));
            	return null;
        	}
        	else {
                response.status(404); // 404 Not found
                return "Library with id " + libraryId + " not found";
        	}
        }, new JsonTransformer());

	}
}
