package onlineStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		String getQuery = "select * from PRODUCT where PRODUCTID='"+productID+"';";
		Statement stmtw = DB.createStatement();
		ResultSet resultSet= stmtw.executeQuery(getQuery);
		
		String  productName;
		String category = null;
		String brand=null;
		
		
		while(resultSet.next()) {
			category = resultSet.getString("CATEGORYNAME");
			brand= resultSet.getString("BRANDNAME");
		}
		String insertQuery = "INSERT INTO ONLINESTOREPRODUCT (PRODUCTID,ONLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,BRANDNAME,CATEGORYNAME)" + "VALUES " + "('"
				+ (productID + storeID) + "', '" + storeID + "','" + productPrice + "'," + quantity + ","
				+ discount + ",0,'" +brand+"','"+ category + "');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);

	}

	public void addOflineProduct(String productID, float productPrice, int quantity, float discount,
			 String storeID) throws SQLException {
		String getQuery = "select * from PRODUCT where PRODUCTID='"+productID+"';";
		Statement stmtw = DB.createStatement();
		ResultSet resultSet= stmtw.executeQuery(getQuery);
		
		String category = null;
		String brand="";
		
		
		while(resultSet.next()) {
			category = resultSet.getString("CATEGORYNAME");
			brand= resultSet.getString("BRANDNAME");
		}
		String insertQuery = "INSERT INTO OFFLINESTOREPRODUCT (PRODUCTID,OFFLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,BRANDNAME,CATEGORYNAME)" + "VALUES " + "('"
				+ (productID + storeID) + "', '" + storeID + "','" + productPrice + "'," + quantity + ","
				+ discount + ",0,'" +brand+"','"+ category + "');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}
	public ArrayList<Product> getProducts() throws SQLException{
		String query ="SELECT * FROM PRODUCT";
		Statement stmtw = DB.createStatement();
		ResultSet resultSet= stmtw.executeQuery(query);
		
		
		ArrayList<Product> products = new ArrayList<>();
		while(resultSet.next()) {
			Product product = new Product();
			product.name = resultSet.getString("CATEGORYNAME");
			product.brandID= resultSet.getString("BRANDNAME");
			product.category= resultSet.getString("CATEGORYNAME");
			product.productID  = resultSet.getString("PRODUCTID");
			product.tybe=resultSet.getBoolean("productType");
			products.add(product);
		}
		return products;
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
	public ArrayList<Product> onlineStoreProducts(String storeID) throws SQLException{
		String query="SELECT * FROM ONLINESTOREPRODUCT WHERE ONLINESTORENAME ='"+storeID+"';";
		Statement st = DB.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		ArrayList<Product> products = new ArrayList<>();
		while(resultSet.next()) {
			Product product = new Product();
			product.numberOfViews=resultSet.getString("numberOfViews");
			product.name = resultSet.getString("CATEGORYNAME");
			product.brandID= resultSet.getString("BRANDNAME");
			product.category= resultSet.getString("CATEGORYNAME");
			product.productID  = resultSet.getString("PRODUCTID");
			product.quantaty=resultSet.getInt("PRODUCTQUANTITY");
			products.add(product);
		}
		return products;
	}
	
	public ArrayList<Product> offlineStoreProducts(String storeID) throws SQLException{
		String query="SELECT * FROM OFFLINESTOREPRODUCT WHERE ONLINESTORENAME ='"+storeID+"';";
		Statement st = DB.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		ArrayList<Product> products = new ArrayList<>();
		while(resultSet.next()) {
			Product product = new Product();
			product.numberOfViews=resultSet.getString("numberOfViews");
			product.name = resultSet.getString("CATEGORYNAME");
			product.brandID= resultSet.getString("BRANDNAME");
			product.category= resultSet.getString("CATEGORYNAME");
			product.productID  = resultSet.getString("PRODUCTID");
			product.quantaty=resultSet.getInt("PRODUCTQUANTITY");
			products.add(product);
		}
		return products;
	}
	
	
	
	
	
	
}
