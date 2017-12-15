package onlineStore;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class SingletonDB {

	private  static SingletonDB DB;
	private final String url = "jdbc:mysql://127.0.0.1:3306/onlineStore";
	private final String username = "root";
	private final String password = "fci1122";
	Connection connection;

	private SingletonDB() throws SQLException {

		System.out.println("Connecting database...");
		connection = (Connection) DriverManager.getConnection(url, username, password);
	}

	public static SingletonDB getDB() throws SQLException {
		if (DB == null) {
			DB = new SingletonDB();
		}
		System.out.println("s");
		return DB;
	}

	public  Connection getConnection() throws SQLException {
		if (DB == null) {
			DB = new SingletonDB();
		}
		System.out.println("s");
		return DB.connection;
	}
}
