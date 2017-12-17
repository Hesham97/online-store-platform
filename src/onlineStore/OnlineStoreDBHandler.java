package onlineStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class OnlineStoreDBHandler {
	private Connection DB;

	public OnlineStoreDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}

	public ArrayList<OnlineStore> getStores() throws SQLException {
		String query = "SELECT * FROM ONLINESTORE ;";
		Statement stmt = (Statement) DB.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<OnlineStore> stores = new ArrayList<>();
		while (resultSet.next()) {
			OnlineStore store = new OfflineStore();
			store.name = resultSet.getString("ONLINESTORENAME");
			store.storeOwnerUserName = resultSet.getString("STOREOWNERUSERNAME");
			stores.add(store);
		}
		return stores;
	}
}
