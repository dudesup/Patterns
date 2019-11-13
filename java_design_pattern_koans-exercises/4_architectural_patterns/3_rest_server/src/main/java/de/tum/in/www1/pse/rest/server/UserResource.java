package de.tum.in.www1.pse.rest.server;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.tum.in.www1.pse.rest.model.User;

public class UserResource {
	
	public static void startResource() {
		// Get all available users (ids)
		get("/users", "application/json", (request, response) -> {
			return ModelStorage.getUsers().keySet();
		}, new JsonTransformer());

		// Get one user for the provided id
		get("/users/:id", (request, response) -> {
			String id = request.params(":id");
			User user = ModelStorage.getUsers().get(id);
			if (user != null) {
				return user;
			} else {
				response.status(404); // 404 Not found
				return "User with id " + id + " not found";
			}
		}, new JsonTransformer());

		// Create a new uawe
		post("/users", (request, response) -> {
			Gson gson = new GsonBuilder().create();
			System.out.println(request.body());
			User newUser = gson.fromJson(request.body(), User.class);
			String id = ModelStorage.createRandomId();
			ModelStorage.getUsers().put(id, newUser);
			newUser.setId(id);
			response.status(201); // 201 Created
			return newUser;
		}, new JsonTransformer());	
	}
}
