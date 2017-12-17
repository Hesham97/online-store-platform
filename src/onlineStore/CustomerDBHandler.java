package onlineStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class CustomerDBHandler {
	private Connection DB;

	public CustomerDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}

	public void addCustomer(String CUSTOMERFNAME, String CUSTOMERUSERNAME, String CUSTOMERSNAME2, String CUSTOMERE_MAIL,
			String CUSTOMERPASSWORD, String CUSTOMERPHONENUMBER) throws SQLException {

		String insertQuery = "INSERT INTO CUSTOMER (CUSTOMERFNAME,CUSTOMERUSERNAME,"
				+ "CUSTOMERSNAME2,CUSTOMERE_MAIL,CUSTOMERPASSWORD,CUSTOMERPHONENUMBER) " + "values ('" + CUSTOMERFNAME
				+ "','" + CUSTOMERUSERNAME + "','" + CUSTOMERSNAME2 + "','" + CUSTOMERE_MAIL + "','" + CUSTOMERPASSWORD
				+ "','" + CUSTOMERPHONENUMBER + "');";
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);
	}

	public Customer SignInByEmail(String identifier, String password) throws SQLException {
		String query = "SELECT * FROM CUSTOMER WHERE CUSTOMERE_MAIL ='" + identifier + "' AND CUSTOMERPASSWORD ='"
				+ password + "'";
		Statement stmt = DB.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		Customer customer = null;
		while (resultSet.next()) {
			customer = new Customer();
			customer.firstName = resultSet.getString("CUSTOMERFNAME");
			customer.email = resultSet.getString("CUSTOMERE_MAIL");
			customer.phoneNumber = resultSet.getString("CUSTOMERPHONENUMBER");
			customer.userName = resultSet.getString("CUSTOMERUSERNAME");
		}
		return customer;
	}

	public Customer SignInByUserName(String identifier, String password) throws SQLException {
		String query = "SELECT * FROM CUSTOMER WHERE CUSTOMERUSERNAME ='" + identifier + "' AND CUSTOMERPASSWORD ='"
				+ password + "'";
		Statement stmt = DB.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		Customer customer = null;
		while (resultSet.next()) {
			customer = new Customer();
			customer.firstName = resultSet.getString("CUSTOMERFNAME");
			customer.email = resultSet.getString("CUSTOMERE_MAIL");
			customer.phoneNumber = resultSet.getString("CUSTOMERPHONENUMBER");
			customer.userName = resultSet.getString("CUSTOMERUSERNAME");
		}
		return customer;
	}
}
