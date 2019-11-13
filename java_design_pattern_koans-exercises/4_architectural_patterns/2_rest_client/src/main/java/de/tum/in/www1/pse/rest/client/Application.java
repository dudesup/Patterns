package de.tum.in.www1.pse.rest.client;

import java.util.List;

import com.mashape.unirest.http.exceptions.UnirestException;

import de.tum.in.www1.pse.rest.model.Company;
import de.tum.in.www1.pse.rest.model.User;

public class Application implements RESTClientDelegate {

	private RESTClient client;
	
	public static void main(String[] args) {
		Application app = new Application();
		app.invokeRESTRequest();
	}
	
	public Application() {
		client = new RESTClient();
		client.setDelegate(this);
	}
	
	public void invokeRESTRequest() {
		try {
			client.getUsers();
			
			User changedUser = new User(10, "Elon Musk", "emusk", "emusk@tesla.de", null, "+14567891", "www.tesla.com", new Company("Testa", "Electric cars", "Batteries"));	
			client.updateUser(changedUser);
			
			User newUser = new User(null, "Elon Musk", "emusk", "emusk@tesla.de", null, "+14567891", "www.tesla.com", new Company("Tesla", "Electric cars", "Batteries"));
			client.createUser(newUser);
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getUsersFinished(List<User> users, int statusCode) {
		System.out.println("Found " + users.size() + " users");
	}

	@Override
	public void createUserFinished(User user, int statusCode) {
		System.out.println("New user " + user.toJson());
	}

	@Override
	public void updateUserFinished(User user, int statusCode) {
		System.out.println("Updated user " + user.toJson());
	}	
}