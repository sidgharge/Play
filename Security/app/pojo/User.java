package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class User extends Model {

	@Id
	int id;

	String name;

	String email;

	String password;

	public static Finder<Integer, User> finder = new Finder<>(User.class);

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
