package onlineStore;

import java.sql.SQLException;

public class Admin {

  public String name;

  public String password;

  public Boolean SignIn() throws SQLException {
	  AdminDBHandler adminDBHandler = new AdminDBHandler();
	  adminDBHandler.FindAdmin();
	  return true;
  }
  
  public void AddBrand(String brandName,String companyName) throws SQLException {
		
  }

  public void AddProduct(String name, String brandID, String category) throws SQLException {
	  
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