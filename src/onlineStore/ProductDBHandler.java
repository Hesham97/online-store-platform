package onlineStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class ProductDBHandler {
	private Connection DB;

	public ProductDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}

	public void addOnlineProduct(String productID, float productPrice, int quantity, float discount,
			 String storeID) throws SQLException {

		/*
	+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| PRODUCTNAME  | varchar(50)  | YES  |     | NULL    |       |
| PRODUCTID    | varchar(100) | NO   | PRI | NULL    |       |
| CATEGORYNAME | varchar(20)  | YES  | MUL | NULL    |       |
| BRANDNAME    | varchar(50)  | YES  | MUL | NULL    |       |
+--------------+--------------+------+-----+---------+-------+

		 * 
		 */
		String getQuery = "select * from PRODUCT where PRODUCTID='"+productID+"';";
		Statement stmtw = DB.createStatement();
		ResultSet resultSet= stmtw.executeQuery(getQuery);
		
		String  productName;
		String category;
		String brand;
		
		
		while(resultSet.next()) {
			
		}
		String insertQuery = "INSERT INTO ONLINESTOREPRODUCT (PRODUCTID,ONLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,CATEGORYNAME)" + "VALUES " + "('"
				+ (productID + storeID) + "', '" + storeID + "'," + "'" + productPrice + "','" + quantity + "','"
				+ discount + "',0,'" + category + "');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}

	public void addOflineProduct(String productID, String productName, float productPrice, int quantity, float discount,
			String category, String storeID) throws SQLException {

		/*
		 * | PRODUCTID | varchar(100) | NO | PRI | NULL | | | ONLINESTORENAME |
		 * varchar(50) | NO | PRI | NULL | | | PRODUCTPRICE | float | YES | | NULL | | |
		 * PRODUCTQUANTITY | int(11) | YES | | NULL | | | PRODUCTDISCOUNT | float | YES
		 * | | NULL | | | numberOfViews | int(11) | YES | | NULL | | | CATEGORYNAME |
		 * varchar(20) | YES | MUL | NULL
		 * 
		 */
		String insertQuery = "INSERT INTO OFFLINESTOREPRODUCT (PRODUCTID,ONLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,CATEGORYNAME)" + "VALUES " + "('"
				+ (productID + storeID) + "', '" + storeID + "'," + "'" + productPrice + "','" + quantity + "','"
				+ discount + "',0,'" + category + "');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}

	public void updateView(String productID) {

	}

	public void updateViewOnlineStore(String productID) throws SQLException {

		String query = "select numberOfViews from ONLINESTOREPRODUCT "
				+ ""
				+ "where PRODUCTID='20150290hamda'";

		Statement st = DB.createStatement();
		ResultSet rs = st.executeQuery(query);
		int numOfViews = 0;
		if (rs.next()) {
			numOfViews = rs.getInt("numberOfViews");
			System.out.println(numOfViews);
		}
		numOfViews++;
		String updateQuery ="UPDATE  ONLINESTOREPRODUCT SET numberOfViews = "+numOfViews+" WHERE PRODUCTID = '"+productID+"'"	 ;	 
				Statement stmt = DB.createStatement();

		stmt.executeUpdate(updateQuery);
	}
	

	public void updateViewOfflineStore(String productID) throws SQLException {

		String query = "select numberOfViews from ONLINESTOREPRODUCT "
				+ ""
				+ "where PRODUCTID='20150290hamda'";

		Statement st = DB.createStatement();
		ResultSet rs = st.executeQuery(query);
		int numOfViews = 0;
		if (rs.next()) {
			numOfViews = rs.getInt("numberOfViews");
			System.out.println(numOfViews);
		}
		numOfViews++;
		String updateQuery ="UPDATE  OFFLINESTOREPRODUCT SET numberOfViews = "+numOfViews+" WHERE PRODUCTID = '"+productID+"'"	 ;	 
				Statement stmt = DB.createStatement();

		stmt.executeUpdate(updateQuery);
	}
}
