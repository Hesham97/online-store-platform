package onlineStore;

import java.sql.ResultSet;
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

	public void addVoucherCart(String serialNumber,float value,int quantity) throws SQLException {
		String query = "INSERT INTO VOUCHERCART (SERAILNUMBER,VoucherCartvalue,quantity) VALUES "
				+ "('"+serialNumber+"',"+value+","+quantity+");";
		Statement st = DB.createStatement();
		st.executeUpdate(query);
	}
	
	public void assignVoucher(String serialNumber,String customerUseName) throws SQLException {
		String query="INSERT INTO VOUCHEREDCUSTOMERS (SERAILNUMBER,CUSTOMERUSERNAME,USED)"
				+ " VALUES ('"+serialNumber+"','"+customerUseName+"',"+0+");"; 
		Statement st = DB.createStatement();
		st.executeUpdate(query);
	}
	public boolean FindAdmin(String userName, String Password) throws SQLException {
		String query = "select * from ADMIN where ADMINNAME ='"+userName+"' and ADMINPASSWORD ='"+Password+"';";
		Statement st = DB.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			return true;
		}

		return false;
	}

	public void addBrand(String brandName, String companyName) throws SQLException {
		String insertQuery = "INSERT INTO BRAND (BRANDNAME,BRANDCOMPANY)" + "VALUES " + "('" + brandName + "', '"
				+ companyName + "');";
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);

	}

	public void addProduct(String productName, String productID, String brand, String category , boolean type) throws SQLException {
		String insertQuery = "INSERT INTO PRODUCT (PRODUCTNAME,PRODUCTID," + "CATEGORYNAME,BRANDNAME,productType)" + "VALUES "
				+ "('" + productName + "', '" + productID + "','" + category + "','" + brand + "',"+type+");";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();
		stmt.executeUpdate(insertQuery);
	}

}
