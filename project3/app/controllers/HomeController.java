package controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import models.Task;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import scala.util.control.Exception;
import services.HomeService;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
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

	/*
	 * public CompletionStage<Result> asyncTask(){
	 * System.out.println("-----------START---------------->");
	 * System.out.println("Request thread: " + Thread.currentThread().getId());
	 * CompletableFuture.supplyAsync(() -> hi(),
	 * httpExecutionContext.current()); CompletableFuture.supplyAsync(() ->
	 * hi(), httpExecutionContext.current()); return
	 * CompletableFuture.supplyAsync(() -> hello(5),
	 * httpExecutionContext.current()).thenApply(answer -> {
	 * System.out.println("Response thread: " + Thread.currentThread().getId());
	 * System.out.println("------------END--------------->"); return ok(answer);
	 * }); }
	 */
	public CompletionStage<Result> simpleAsync() {
		System.out.println("-----------START---------------->");
		System.out.println("Request thread: " + Thread.currentThread().getId());
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> hi(2), httpExecutionContext.current());
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> hi(5), httpExecutionContext.current());

		return CompletableFuture.allOf(future1, future2).thenApply((a) -> {
			System.out.println("Response thread: " + Thread.currentThread().getId());
			System.out.println("------------END--------------->");
			return ok("Hello, world");
		});
	}

	public String hi(int sleep) {
		try {
			Thread.sleep(sleep * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		;
		System.out.println("Hi thread: " + Thread.currentThread().getId());
		return "hello";
	}

	public CompletionStage<Result> failureAsync() {
		System.out.println("-----------START---------------->");
		System.out.println("Request thread: " + Thread.currentThread().getId());
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> failure(2),
				httpExecutionContext.current());
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> failure(5),
				httpExecutionContext.current());

		return CompletableFuture.allOf(future1, future2).thenApply((a) -> {
			System.out.println("Response thread: " + Thread.currentThread().getId());
			if (!future1.isCompletedExceptionally()) {
				System.out.println("Errr...");
			}
			System.out.println("------------END--------------->");
			return ok("Hello, world");
		});
	}

	public String failure(int sleep) throws ArithmeticException {
		try {
			Thread.sleep(sleep * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hi thread: " + Thread.currentThread().getId());
		return "hello";
	}

	public CompletionStage<Result> imgDownload() {
		long time = System.currentTimeMillis();
		System.out.println("-----------START---------------->");
		System.out.println("Request thread: " + Thread.currentThread().getId());
		HomeService service = new HomeService();
		service.imgUrl = "https://lh3.googleusercontent.com/-C4S9CsIRFJ4/AAAAAAAAAAI/AAAAAAAAGes/eQsBifYI940/photo.jpg";
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> service.downloadImage(),
				httpExecutionContext.current());

		HomeService service2 = new HomeService();
		service2.imgUrl = "https://lh4.googleusercontent.com/-GV9rduTpcgQ/AAAAAAAAAAI/AAAAAAAAABQ/03vXLUMfdRo/photo.jpg";
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> service2.downloadImage(),
				httpExecutionContext.current());

		return CompletableFuture.allOf(future1, future2).thenApply((a) -> {
			System.out.println("Response thread: " + Thread.currentThread().getId());
			System.out.println("Time used: " + (System.currentTimeMillis() - time));
			System.out.println("------------END--------------->");
			return ok("Time used: " + (System.currentTimeMillis() - time));

		});
	}

	public Result imgDownloadWithoutAsync() {
		long time = System.currentTimeMillis();
		System.out.println("-----------START---------------->");
		System.out.println("Request thread: " + Thread.currentThread().getId());
		HomeService service = new HomeService();
		service.imgUrl = "https://lh3.googleusercontent.com/-C4S9CsIRFJ4/AAAAAAAAAAI/AAAAAAAAGes/eQsBifYI940/photo.jpg";
		service.downloadImage();

		HomeService service2 = new HomeService();
		service2.imgUrl = "https://lh4.googleusercontent.com/-GV9rduTpcgQ/AAAAAAAAAAI/AAAAAAAAABQ/03vXLUMfdRo/photo.jpg";
		service2.downloadImage();

		System.out.println("Response thread: " + Thread.currentThread().getId());
		System.out.println("Time used: " + (System.currentTimeMillis() - time));
		System.out.println("------------END--------------->");

		return ok("Time used: " + (System.currentTimeMillis() - time));
	}
	
	public Result imgSmall() {
		long time = System.currentTimeMillis();
		System.out.println("-----------START---------------->");
		System.out.println("Request thread: " + Thread.currentThread().getId());
		HomeService service = new HomeService();
		service.imgUrl = "https://lh3.googleusercontent.com/-C4S9CsIRFJ4/AAAAAAAAAAI/AAAAAAAAGes/eQsBifYI940/photo.jpg";
		service.downloadImage();

		System.out.println("Response thread: " + Thread.currentThread().getId());
		System.out.println("Time used: " + (System.currentTimeMillis() - time));
		System.out.println("------------END--------------->");

		return ok("Time used: " + (System.currentTimeMillis() - time));
	}
	
	public Result imgBig() {
		long time = System.currentTimeMillis();
		System.out.println("-----------START---------------->");
		System.out.println("Request thread: " + Thread.currentThread().getId());

		HomeService service2 = new HomeService();
		service2.imgUrl = "https://www.w3schools.com/css/trolltunga.jpg";
		service2.downloadImage();

		System.out.println("Response thread: " + Thread.currentThread().getId());
		System.out.println("Time used: " + (System.currentTimeMillis() - time));
		System.out.println("------------END--------------->");

		return ok("Time used: " + (System.currentTimeMillis() - time));
	}
	
	public Result readFile() {
		long time = System.currentTimeMillis();
		System.out.println("-----------START---------------->");
		System.out.println("Request thread: " + Thread.currentThread().getId());

		HomeService service = new HomeService();
		service.readFile();

		System.out.println("Response thread: " + Thread.currentThread().getId());
		System.out.println("Time used: " + (System.currentTimeMillis() - time));
		System.out.println("------------END--------------->");

		return ok("Time used: " + (System.currentTimeMillis() - time));
	}
	
	

	private HttpExecutionContext httpExecutionContext;

	@Inject
	public HomeController(HttpExecutionContext ec) {
		this.httpExecutionContext = ec;
	}

}
