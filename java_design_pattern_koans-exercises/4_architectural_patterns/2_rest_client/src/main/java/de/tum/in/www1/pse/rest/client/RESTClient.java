package de.tum.in.www1.pse.rest.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.tum.in.www1.pse.rest.model.User;

public class RESTClient {

	private RESTClientDelegate delegate;

	public RESTClientDelegate getDelegate() {
		return delegate;
	}

	public void setDelegate(RESTClientDelegate delegate) {
		this.delegate = delegate;
	}

	public void getUsers() throws UnirestException {
		
		//TODO: use the correct URL for GET
		Unirest.get("GET-URL").asJsonAsync(new Callback<JsonNode>() {

			public void failed(UnirestException e) {
				System.out.println("GET users request has failed");
			}

			public void completed(HttpResponse<JsonNode> response) {
				//TODO: implement proper response handling 
			}

			public void cancelled() {
				System.out.println("GET users request has been cancelled");
			}

		});
	}

	public void updateUser(User user) throws UnirestException {
		//TODO: implement the PUT Request
		throw new RuntimeException("PUT user is not implemented");
	}


	public void createUser(User user) throws UnirestException {
		//TODO: implement the POST Request
		throw new RuntimeException("POST user is not implemented");
	}
}
