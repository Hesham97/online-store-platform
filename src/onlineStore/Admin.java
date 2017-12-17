package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class Admin {

	public String name;

  	public String password;

  	AdminDBHandler adminDBHandler = new AdminDBHandler();
  	ProductDBHandler productDBHandler = new ProductDBHandler();
  
  	public boolean SignIn() throws SQLException {
	  	return adminDBHandler.FindAdmin(name,password);
  	}
  
  	public void AddBrand(String brandName,String companyName) throws SQLException {
  		adminDBHandler.addBrand(brandName,companyName);
  	}

  	public void AddProduct(String name, String productID , String brandID, String category ,boolean type) throws SQLException {
	  	adminDBHandler.addProduct(name,productID,brandID,category,type);
  	}
  
  	public void AddVoucherCard(String serialNumber,float value,int quantity) throws SQLException{
	  	adminDBHandler.addVoucherCart(serialNumber,value,quantity);
  	}
  
  	public void assignVoucher(String serialNumber, String customerUseName) throws SQLException {
  		adminDBHandler.assignVoucher(serialNumber, customerUseName);
  	}
  	
  	public ArrayList<Product> getProducts(String storeID, boolean type) throws SQLException {	
  		ArrayList<Product> products = null;
		if(!type)
			products = productDBHandler.onlineStoreProducts (storeID);
		else
			products = productDBHandler.offlineStoreProducts (storeID);
		return products;
	}

  	public void DeleteProduct(String productID) throws SQLException {}

  	public void RemoveStore(String storeID) throws SQLException {}

  	public void BlockStoreOwner(String storeOwnerID) throws SQLException {}
  
  	public void BlockUser(String customerName) throws SQLException {}

  //public Stat ShowStat() { return null;}
  
}