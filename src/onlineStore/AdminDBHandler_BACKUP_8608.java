package onlineStore;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class AdminDBHandler {
	private Connection DB;

	public AdminDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}
	
	//radwan
	//true if founded false if not
	public void FindAdmin()  throws SQLException {
		
	}
	//end radwan
	
	public void addBrand(String brandName,String companyName) throws SQLException {
		String insertQuery = "INSERT INTO BRAND (BRANDNAME,BRANDCOMPANY)"
				+ "VALUES " + "('" + brandName + "', '" + companyName + "');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);
	}
	public void addProduct(String productName,String productID,String category)
			throws SQLException {
		
	/*	|  PRODUCTNAME    | varchar(50)  | YES  |     | NULL    |       |
		| PRODUCTID       | varchar(100) | NO   | PRI | NULL    |       |
		| CATEGORYNAME    | varchar(20)  | YES  | MUL | NULL    |       |
		| PRODUCTPRICE    | float        | YES  |     | NULL    |       |
		| PRODUCTQUANTITY | int(11)      | YES  |     | NULL    |       |
		| PRODUCTDISCOUNT | float        | YES  |     | NULL    |       |
		| numberOfViews   | int(11)      | YES  |     | NULL    |       |
*/
		String insertQuery = "INSERT INTO PRODUCT (PRODUCTNAME,PRODUCTID,CATEGORYNAME)"
				+ "VALUES " + "('" + productName + "', '" + productID + "','" + category 
				+"');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}
	
}
