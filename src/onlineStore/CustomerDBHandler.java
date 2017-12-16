package onlineStore;

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
	
	/*
+---------------------+--------------+------+-----+---------+-------+
| Field               | Type         | Null | Key | Default | Extra |
+---------------------+--------------+------+-----+---------+-------+
| CUSTOMERFNAME       | varchar(15)  | YES  |     | NULL    |       |
| CUSTOMERUSERNAME    | varchar(20)  | NO   | PRI | NULL    |       |
| CUSTOMERSNAME2      | varchar(15)  | YES  |     | NULL    |       |
| CUSTOMERE_MAIL      | varchar(100) | YES  |     | NULL    |       |
| CUSTOMERPASSWORD    | varchar(100) | YES  |     | NULL    |       |
| CUSTOMERPHONENUMBER | varchar(12)  | YES  |     | NULL    |       |
+---------------------+--------------+------+-----+---------+-------+
	 */
	
	public void addCustomer(String CUSTOMERFNAME, String CUSTOMERUSERNAME, 
			String CUSTOMERSNAME2, String CUSTOMERE_MAIL,
			String CUSTOMERPASSWORD, String CUSTOMERPHONENUMBER) throws SQLException {
		
		String insertQuery = "INSERT INTO CUSTOMER (CUSTOMERFNAME,CUSTOMERUSERNAME,"
				+ "CUSTOMERSNAME2,CUSTOMERE_MAIL,CUSTOMERPASSWORD,CUSTOMERPHONENUMBER) "
				+ "values ('"+CUSTOMERFNAME+"','"+ CUSTOMERUSERNAME+"','"+CUSTOMERSNAME2+
				"','"+CUSTOMERE_MAIL+"','"+CUSTOMERPASSWORD+"','"+CUSTOMERPHONENUMBER+"');";
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);
	}
}
