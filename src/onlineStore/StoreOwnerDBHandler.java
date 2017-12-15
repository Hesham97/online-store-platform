package onlineStore;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class StoreOwnerDBHandler {

	private Connection DB;

	public StoreOwnerDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}
	public void addProductToStore(String productName,String productID,String category,
			String OnlineStoreName,float productPrice,
			int quantity,float discount) throws SQLException {
		
		/*	PRODUCTID       | varchar(100) | NO   | PRI | NULL    |       |
			| ONLINESTORENAME | varchar(50)  | NO   | PRI | NULL    |       |
			| PRODUCTPRICE    | float        | YES  |     | NULL    |       |
			| PRODUCTQUANTITY | int(11)      | YES  |     | NULL    |       |
			| PRODUCTDISCOUNT | float        | YES  |     | NULL    |       |
			| numberOfViews */
		String insertQuery = "INSERT INTO PRODUCT (PRODUCTID,ONLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews)"
				+ "VALUES " + "('" + productID+OnlineStoreName + "', '" + OnlineStoreName + "','" + productPrice 
				+"','"+quantity+"','"+discount+"''0');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}
	public void createOffilneStore(String storeName, String ownerUserName, String storeAddress) throws SQLException {
		String insertQuery = "INSERT INTO OFFLINESTORE (OFFLINESTORENAME,STOREOWNERUSERNAME" + ",OFFLINESTOREADDRESS)"
				+ "VALUES " + "('" + storeName + "', '" + ownerUserName + "','" + storeAddress + "');";
		// System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}

	public void createOnlineStore(String storeName, String ownerUserName) throws SQLException {
		String insertQuery = "INSERT INTO ONLINESTORE (ONLINESTORENAME,STOREOWNERUSERNAME)"
				+ "VALUES " + "('" + storeName + "', '" + ownerUserName + "');";
		// System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);

	}

}
