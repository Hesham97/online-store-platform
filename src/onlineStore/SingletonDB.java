package onlineStore;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class SingletonDB {

	private static SingletonDB DB; 
	String url = "jdbc:mysql://127.0.0.1:3306/onlineStore";
	String username = "root";
	String password = "fci1122";

	private SingletonDB() {

		System.out.println("Connecting database...");

		try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}	}
	
	public static SingletonDB getDB() {
		if(DB==null) {
			DB=new SingletonDB();
		}
		System.out.println("s");
		return DB;
	}

	void act() {System.out.println("s");		
	}
}
