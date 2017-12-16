package onlineStore;

import java.sql.SQLException;

public class AdminController {
  
	Admin admin = null;
	
	public void SignIn(String name, String password) throws SQLException {
		admin = new Admin();
		admin.name = name;
		admin.password = password;
		admin.SignIn();
	}
	
	public void AddBrand(String brandName,String companyName) throws SQLException {
		admin.AddBrand(brandName, companyName);
	}
	
	public void AddProduct(String name, String brandID, String category) throws SQLException {
		admin.AddProduct(name, brandID, category);
	}
	
	public void DeleteProduct(String productID) throws SQLException {
		admin.DeleteProduct(productID);
	}
	
	public void RemoveStore(String storeID) throws SQLException {
		admin.RemoveStore(storeID);
	}
	
	public void BlockStoreOwner(String storeOwnerID) throws SQLException {
		admin.BlockStoreOwner(storeOwnerID);
	}
	
	public void BlockUser(String customerName) throws SQLException {
		admin.BlockUser(customerName);
	}
	
	// public Stat ShowStat(){}
	
}