package controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.FutureTask;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import models.Task;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
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
    
    public CompletionStage<Result> asyncTask(){
    	System.out.println("Main thread: " + Thread.currentThread().getId());
        CompletableFuture.supplyAsync(() -> hi());
        CompletableFuture.supplyAsync(() -> hi());
        return CompletableFuture.supplyAsync(() -> hello()).thenApply(answer -> {
        	System.out.println("After response thread: " + Thread.currentThread().getId());
            return ok("answer was " + answer);
        });
    }
    
    private static CompletionStage<String> calculateResponse() {
    	System.out.println("In calculate thread: " + Thread.currentThread().getId());
        return CompletableFuture.completedFuture("42");
    }
    
    public String hello(){
    	System.out.println("Hello thread: " + Thread.currentThread().getId());
    	return "hello";
    }
    
    public String hi(){
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
    	System.out.println("Hi thread: " + Thread.currentThread().getId());
    	return "hello";
    }
    
    
}
