package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class Task extends Model {

	@Id
	public int id;
	
	public String title;
	
	public String content;
	
	public static Finder<String, Task> find = new Finder<>(Task.class);

}
