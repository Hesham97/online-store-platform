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
