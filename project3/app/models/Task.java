package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class Task extends Model {

	@Id
	public int id;
	
	public String title;
	
	public String content;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	public String image;
	
	public static Finder<String, Task> find = new Finder<>(Task.class);

}
