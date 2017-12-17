package onlineStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class OfflineStoreDBHandler {
	private Connection DB;

	public OfflineStoreDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}

	public ArrayList<OfflineStore> getStores() throws SQLException {
		String query = "SELECT * FROM OFFLINESTORE ";
		Statement stmt = (Statement) DB.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<OfflineStore> stores = new ArrayList<OfflineStore>();
		while (resultSet.next()) {
			OfflineStore store = new OfflineStore();
			store.name = resultSet.getString("OFFLINESTORENAME");
			store.Address = resultSet.getString("OFFLINESTOREADDRESS");
			store.storeOwnerUserName = resultSet.getString("STOREOWNERUSERNAME");
			stores.add(store);
		}
		return stores;
	}
}
