package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Task;
import play.libs.Json;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    
    public Result addTask() {
    	JsonNode jsonNode = request().body().asJson();
    	Task task = Json.fromJson(jsonNode, Task.class);
    	task.save();
        return ok();
    }
    
    public Result getTasks() {
    	List<Task> tasks = Task.find.all();
        return ok(Json.toJson(tasks));
    }
    
    public Result getTaskById(Integer id) {
    	Task task = Task.find.byId(String.valueOf(id));
        return ok(Json.toJson(task));
    }
    
    public Result updateTask(Integer id) {
    	JsonNode jsonNode = request().body().asJson();
    	Task task = Json.fromJson(jsonNode, Task.class);
    	
    	Task oldTask = Task.find.byId(String.valueOf(id));
    	oldTask.title = task.title;
    	oldTask.content = task.content;
    	oldTask.save();
        return ok();
    }
    
    public Result deleteTask(Integer id) {
    	Task.find.deleteById(String.valueOf(id));
        return ok();
    }

}