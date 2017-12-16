package onlineStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class StoreOwnerDBHandler {

	private Connection DB;
	private StoreOwner owner;
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

	public void SignUp(String _name, String _userName, String _password, String _phoneNumber, String _address,
			String _premium) throws SQLException {
		/*
		 * +-----------------------+--------------+------+-----+---------+-------+
| Field                 | Type         | Null | Key | Default | Extra |
+-----------------------+--------------+------+-----+---------+-------+
| STOREOWNERNAME        | varchar(15)  | YES  |     | NULL    |       |
| STOREOWNERPHONENUMBER | varchar(12)  | YES  |     | NULL    |       |
| STOREOWNERBALANCE     | float        | YES  |     | NULL    |       |
| STOREOWNERASDRESS     | varchar(200) | YES  |     | NULL    |       |
| STOREOWNERUSERNAME    | varchar(20)  | NO   | PRI | NULL    |       |
| Premium               | tinyint(1)   | NO   |     | 0       |       |
| STOREOWNERPASSWORD    | varchar(8)   | YES  |     | NULL    |       |
+-----------------------+--------------+------+-----+---------+-------+

		 * 
		 * 
		 */
		String insertQuery ="INSERT INTO STOREOWNER(STOREOWNERNAME,STOREOWNERPHONENUMBER,STOREOWNERBALANCE,"
				+ "STOREOWNERASDRESS,STOREOWNERUSERNAME,Premium,STOREOWNERPASSWORD) VALUES('"+_name
				+"','"+_phoneNumber+"',"+0.0+",'"+_address+"','"+_userName+"',"+_premium+",'"+_password+"');";
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);
				
	}
	public StoreOwner SignIn(String _userName, String _password) throws SQLException {
			String query = "select * from STOREOWNER where STOREOWNERUSERNAME ='"+_userName+"' and STOREOWNERPASSWORD ='"+_password+"';";
			owner = new StoreOwner();
			Statement st = DB.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				owner.name=rs.getString("STOREOWNERNAME");
				owner.phoneNumber = rs.getString("STOREOWNERPHONENUMBER");
				owner.address = rs.getString("STOREOWNERASDRESS");
				owner.premium = rs.getBoolean("Premium");
				owner.balance = rs.getDouble("STOREOWNERBALANCE");
				return owner;
			}
		return null;
	}

}
