package onlineStore;

import java.sql.SQLException;

public class Admin {

  public String name;

  public String password;

  AdminDBHandler adminDBHandler = new AdminDBHandler();
  
  public boolean SignIn() throws SQLException {
	  System.out.println(adminDBHandler.FindAdmin(name,password));
	  return adminDBHandler.FindAdmin(name,password);
  }
  
  public void AddBrand(String brandName,String companyName) throws SQLException {
	  adminDBHandler.addBrand(brandName,companyName);
  }

  public void AddProduct(String name, String productID , String brandID, String category) throws SQLException {
	  adminDBHandler.addProduct(name,productID,brandID,category);
  }
  
  public void AddVoucherCard(String serialNumber,float value,int quantity){
	  adminDBHandler.AddVoucherCard(serialNumber,value,quantity);
  }

  public void DeleteProduct(String productID) throws SQLException {
	   
  }

  public void RemoveStore(String storeID) throws SQLException {
	  
  }

  public void BlockStoreOwner(String storeOwnerID) throws SQLException {
	  
  }
  
  public void BlockUser(String customerName) throws SQLException {
	  
  }

  //public Stat ShowStat() { return null;}
  
}