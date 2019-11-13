package de.tum.in.www1.pse.rest.client;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.junit.Before;
import org.junit.Test;


import com.mashape.unirest.http.exceptions.UnirestException;

import de.tum.in.www1.pse.rest.client.RESTClient;
import de.tum.in.www1.pse.rest.client.RESTClientDelegate;
import de.tum.in.www1.pse.rest.model.Address;
import de.tum.in.www1.pse.rest.model.Company;
import de.tum.in.www1.pse.rest.model.GeoLocation;
import de.tum.in.www1.pse.rest.model.User;

public class RESTClientTest implements RESTClientDelegate {

	private RESTClient client;
	private List<User> users = new ArrayList<User>();
	private int statusCode = 0;
	
	@Before
	public void setup() {
		client = new RESTClient();
		client.setDelegate(this);
	}

	@Test(timeout = 6000)
	public void testGetUsers() throws UnirestException {
		client.getUsers();
		await().atMost(3, SECONDS).until(() -> assertThat("The number of users after GET users is wrong", users, hasSize(10)));
		await().atMost(3, SECONDS).until(() -> assertThat("The status code of the GET request is wrong", statusCode, is(200)));
		await().atMost(3, SECONDS).until(testGetUsersAssertions());
	}

	private Callable<Boolean> testGetUsersAssertions() {
		return new Callable<Boolean>() {
			public Boolean call() throws Exception {
				if (users.size() < 1) {
					throw new AssertionError("Not enough users parsed during GET users");
				}
				for (User user : users) {
					if (user.getAddress() == null) {
						throw new AssertionError("Address not parsed correctly during GET users");
					}
					Address address = user.getAddress();
					if(address.getGeoLocation() == null) {
						throw new AssertionError("GeoLocation not parsed correctly during GET users");
					}
					GeoLocation geoLocation = address.getGeoLocation();
					if(geoLocation.getLatitude() == null) {
						throw new AssertionError("Latitude not parsed correctly during GET users");
					}
					if(geoLocation.getLongitude() == null) {
						throw new AssertionError("Longitude not parsed correctly during GET users");
					}
				}
				return true;
			}
		};
	}
	
	@Test(timeout = 6000)
	public void testCreateUsers() throws UnirestException {
		User newUser = new User(null, "Elon Musk", "emusk", "emusk@tesla.de", null, "+14567891", "www.tesla.com", new Company("Tesla", "Electric cars", "Batteries"));
		client.createUser(newUser);
		await().atMost(3, SECONDS).until(() -> assertThat("The user id after POST is missing", newUser.getId(), is(11)));
		await().atMost(3, SECONDS).until(() -> assertThat("The status code of the POST request is wrong", statusCode, is(201)));
	}
	
	@Test(timeout = 6000)
	public void testUpdateUsers() throws UnirestException {
		User updatedUser = new User(10, "Elon Musk", "emusk", "emusk@tesla.de", null, "+14567891", "www.tesla.com", new Company("Tesla", "Electric cars", "Batteries"));
		client.updateUser(updatedUser);
		await().atMost(3, SECONDS).until(() -> assertThat("The status code of the PUT request is wrong", statusCode, is(200)));
	}

	@Override
	public void getUsersFinished(List<User> users, int statusCode) {
		this.users = users;
		this.statusCode = statusCode;
	}

	@Override
	public void createUserFinished(User user, int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public void updateUserFinished(User user, int statusCode) {
		this.statusCode = statusCode;
	}
}
