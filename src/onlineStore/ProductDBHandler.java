package onlineStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class ProductDBHandler {
	private Connection DB;
	ArrayList<Product> products = new ArrayList<>();

	public ProductDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}

	public void suggestProduct(String productName, String productID, String brand, String category, boolean type)
			throws SQLException {
		String insertQuery = "INSERT INTO SUGGESTION (PRODUCTNAME,PRODUCTID," + "CATEGORYNAME,BRANDNAME,productType)"
				+ "VALUES " + "('" + productName + "', '" + productID + "','" + category + "','" + brand + "'," + type
				+ ");";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);
	}

	public void addOnlineProduct(String productID, float productPrice, int quantity, float discount, String storeID)
			throws SQLException {
		String getQuery = "select * from PRODUCT where PRODUCTID='" + productID + "';";
		Statement stmtw = DB.createStatement();
		ResultSet resultSet = stmtw.executeQuery(getQuery);

		String productName=null;
		String category = null;
		String brand = null;

		while (resultSet.next()) {
			category = resultSet.getString("CATEGORYNAME");
			brand = resultSet.getString("BRANDNAME");
			productName = resultSet.getString("PRODUCTNAME");
		}
		String insertQuery = "INSERT INTO ONLINESTOREPRODUCT (PRODUCTID,ONLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,BRANDNAME,CATEGORYNAME,PRODUCTNAME)" + "VALUES " + "('"
				+ (productID + storeID) + "', '" + storeID + "'," + productPrice + "," + quantity + "," + discount
				+ ",0,'" + brand + "','" + category + "','"+productName+"');";
		//System.out.println(insertQuery);
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);

	}

	public void addOflineProduct(String productID, float productPrice, int quantity, float discount, String storeID)
			throws SQLException {
		String getQuery = "select * from PRODUCT where PRODUCTID='" + productID + "';";
		Statement stmtw = DB.createStatement();
		ResultSet resultSet = stmtw.executeQuery(getQuery);

		String category = null;
		String brand = "";
		String productName=null;

		while (resultSet.next()) {
			category = resultSet.getString("CATEGORYNAME");
			brand = resultSet.getString("BRANDNAME");
			productName = resultSet.getString("PRODUCTNAME");
		}
		String insertQuery = "INSERT INTO OFFLINESTOREPRODUCT (PRODUCTID,OFFLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,BRANDNAME,CATEGORYNAME,PRODUCTNAME)" + "VALUES " + "('"
				+ (productID + storeID) + "', '" + storeID + "','" + productPrice + "'," + quantity + "," + discount
				+ ",0,'" + brand + "','" + category + "','"+productName+"');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}

	public ArrayList<Product> getProducts() throws SQLException {
		String query = "SELECT * FROM PRODUCT";
		Statement stmtw = DB.createStatement();
		ResultSet resultSet = stmtw.executeQuery(query);

		//ArrayList<Product> products = new ArrayList<>();
		while (resultSet.next()) {
			Product product = new Product();
			product.name = resultSet.getString("CATEGORYNAME");
			product.brandID = resultSet.getString("BRANDNAME");
			product.category = resultSet.getString("CATEGORYNAME");
			product.productID = resultSet.getString("PRODUCTID");
			product.tybe = resultSet.getBoolean("productType");
			products.add(product);
		}
		return products;
	}

	public void updateView(String productID) {

	}

	public void updateViewOnlineStore(String productID) throws SQLException {

		String query = "select numberOfViews from ONLINESTOREPRODUCT " + "" + "where PRODUCTID='20150290hamda'";

		Statement st = DB.createStatement();
		ResultSet rs = st.executeQuery(query);
		int numOfViews = 0;
		if (rs.next()) {
			numOfViews = rs.getInt("numberOfViews");
			System.out.println(numOfViews);
		}
		numOfViews++;
		String updateQuery = "UPDATE  ONLINESTOREPRODUCT SET numberOfViews = " + numOfViews + " WHERE PRODUCTID = '"
				+ productID + "'";
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(updateQuery);
	}

	public void updateViewOfflineStore(String productID) throws SQLException {

		String query = "select numberOfViews from ONLINESTOREPRODUCT " + "" + "where PRODUCTID='20150290hamda'";

		Statement st = DB.createStatement();
		ResultSet rs = st.executeQuery(query);
		int numOfViews = 0;
		if (rs.next()) {
			numOfViews = rs.getInt("numberOfViews");
			System.out.println(numOfViews);
		}
		numOfViews++;
		String updateQuery = "UPDATE  OFFLINESTOREPRODUCT SET numberOfViews = " + numOfViews + " WHERE PRODUCTID = '"
				+ productID + "'";
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(updateQuery);
	}

	public ArrayList<Product> onlineStoreProducts(String storeID) throws SQLException {
		String query = "SELECT * FROM ONLINESTOREPRODUCT WHERE ONLINESTORENAME ='" + storeID + "';";
		Statement st = DB.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		while (resultSet.next()) {
			Product product = new Product();
			product.numberOfViews = resultSet.getInt("numberOfViews");
			product.name = resultSet.getString("CATEGORYNAME");
			product.brandID = resultSet.getString("BRANDNAME");
			product.category = resultSet.getString("CATEGORYNAME");
			product.productID = resultSet.getString("PRODUCTID");
			product.quantaty = resultSet.getInt("PRODUCTQUANTITY");
			products.add(product);
		}
		System.out.println(products.get(0).category+"zzzzzzzzzz");
		return products;
	}

	public ArrayList<Product> offlineStoreProducts(String storeID) throws SQLException {
		String query = "SELECT * FROM OFFLINESTOREPRODUCT WHERE OFFLINESTORENAME='" + storeID + "';";
		Statement st = DB.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		ArrayList<Product> products = new ArrayList<>();
		while (resultSet.next()) {
			Product product = new Product();
			product.numberOfViews = resultSet.getInt("numberOfViews");
			product.name = resultSet.getString("CATEGORYNAME");
			System.out.println(product.name);
			product.brandID = resultSet.getString("BRANDNAME");
			product.category = resultSet.getString("CATEGORYNAME");
			product.productID = resultSet.getString("PRODUCTID");
			product.quantaty = resultSet.getInt("PRODUCTQUANTITY");
			products.add(product);
		}
		System.out.println(products.size() + "zzz");
		return products;
	}

	private ArrayList<Product> returnProudct(String query) throws SQLException {
		Statement st = DB.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		ArrayList<Product> products = new ArrayList<>();
		while (resultSet.next()) {
			Product product = new Product();
			product.numberOfViews = resultSet.getInt("numberOfViews");
			product.name = resultSet.getString("CATEGORYNAME");
			product.brandID = resultSet.getString("BRANDNAME");
			product.category = resultSet.getString("CATEGORYNAME");
			product.productID = resultSet.getString("PRODUCTID");
			product.quantaty = resultSet.getInt("PRODUCTQUANTITY");
			products.add(product);
		}
		return products;
	}

	public ArrayList<Product> getProductByPrice(float producrPrice) throws SQLException {
		String query = "SELECT * FROM ONLINESTOREPRODUCT WHERE PRODUCTPRICE=" + producrPrice + ";";
		String _query = "SELECT * FROM OFFLINESTOREPRODUCT WHERE PRODUCTPRICE=" + producrPrice + ";";

		ArrayList<Product> proudcts = returnProudct(query);
		proudcts.addAll(returnProudct(_query));
		return proudcts;
	}

	public ArrayList<Product> getProductByName(String name) throws SQLException {
		String query = "SELECT * FROM ONLINESTOREPRODUCT WHERE ONLINESTORENAME='" + name + "';";
		String _query = "SELECT * FROM OFFLINESTOREPRODUCT WHERE OFFLINESTORENAME='" + name + "';";
		ArrayList<Product> proudcts = returnProudct(query);
		proudcts.addAll(returnProudct(_query));
		return proudcts;
	}

	public ArrayList<Product> getProductByCategory(String category) throws SQLException {
		String query = "SELECT * FROM ONLINESTOREPRODUCT WHERE CATEGORYNAME='" + category + "';";
		String _query = "SELECT * FROM OFFLINESTOREPRODUCT WHERE CATEGORYNAME='" + category + "';";
		ArrayList<Product> proudcts = returnProudct(query);
		proudcts.addAll(returnProudct(_query));
		return proudcts;
	}

	public ArrayList<Product> getProductByBrand(String brandName) throws SQLException {
		String query = "SELECT * FROM ONLINESTOREPRODUCT WHERE BRANDNAME='" + brandName + "';";
		String _query = "SELECT * FROM OFFLINESTOREPRODUCT WHERE BRANDNAME='" + brandName + "';";
		ArrayList<Product> proudcts = returnProudct(query);
		proudcts.addAll(returnProudct(_query));
		return proudcts;
	}

}
