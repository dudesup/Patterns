package de.tum.in.www1.pse.rest.client;

import java.util.List;

import de.tum.in.www1.pse.rest.model.User;

public interface RESTClientDelegate {
	public void getUsersFinished(List<User> users, int statusCode);
	public void createUserFinished(User user, int statusCode);
	public void updateUserFinished(User user, int statusCode);
}
