package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.*;
import pojo.User;


public class HomeController extends Controller {

	public Result register(){
		JsonNode node = request().body().asJson();
		User user = Json.fromJson(node, User.class);
		System.out.println(user);
		try {
			user.save();
			return ok("Registered");
		} catch (Exception e) {
			return ok("Failed to register: " + e.getMessage());
		}
	}
	
	public Result getUserById(Integer id){
		User user = User.finder.byId(id);
		return ok(Json.toJson(user));
	}

}
