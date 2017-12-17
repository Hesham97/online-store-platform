package onlineStore;

import java.sql.SQLException;

public class AdminController {
  
	Admin admin = null;
	
	public boolean SignIn(String name, String password) throws SQLException {
		admin = new Admin();
		admin.name = name;
		admin.password = password;
		return admin.SignIn();
	}
	
	public void AddBrand(String brandName,String companyName) throws SQLException {
		admin.AddBrand(brandName, companyName);
	}
	
	public void AddProduct(String name, String productID , String brandID, String category,boolean type) throws SQLException {
		admin.AddProduct(name , productID , brandID, category,type);
	}
	
	public void AddVoucherCard(String serialNumber, float value, int quantity) throws SQLException {
		admin.AddVoucherCard(serialNumber, value, quantity);
	}
	
	public void assignVoucher(String serialNumber,String customerUseName) throws SQLException {
		admin.assignVoucher(serialNumber,customerUseName);
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