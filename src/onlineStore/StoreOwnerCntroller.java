package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class StoreOwnerCntroller {
	
	StoreOwner storeOwner = new StoreOwner();
	
	public boolean IsPremium() {
		return storeOwner.premium;
	}
	
	public void SignUp(String _name ,String _userName ,String _password , String _phoneNumber , String _address , String _premium) throws SQLException {
		storeOwner.SignUp(_name ,_userName,_password,_phoneNumber,_address,_premium);
	}
	
	public boolean SignIn(String _userName ,String _password) throws SQLException {
		storeOwner.userName = _userName;
		storeOwner.password = _password;
		return storeOwner.SignIn(_userName ,_password);
	}
	
	public void AddProductToOnlineStore(String storeID, String productID, float price, int quantaty, float discount) throws SQLException {
		storeOwner.AddProductToOnlineStore(storeID, productID, price, quantaty, discount);
	}
	
	public void AddProductToOfflineStore(String storeID, String productID, float price, int quantaty, float discount) throws SQLException {
		storeOwner.AddProductToOfflineStore(storeID,productID,price,quantaty,discount);
	}
	
	public void AddOnlineStore(String name,String storeOwnerUserName) throws SQLException {
		storeOwner.AddOnlineStore(name, storeOwnerUserName);
	}
	
	public void AddOfflineStore(String name,String address , String storeOwnerUserName) throws SQLException {
		storeOwner.AddOfflineStore(name, storeOwnerUserName, address);
	}
	
	public ArrayList<Product> GetAllProducts() throws SQLException{
		ProductDBHandler dbHandler = new ProductDBHandler();
		return dbHandler.getProducts();
	}
	
	public ArrayList<Product> getProducts(String storeID,boolean storeType) throws SQLException{
		return storeOwner.getProducts(storeID,storeType);
	}
	
	public ArrayList<Product> GetTheMostViewedProduct(String storeID , boolean storeType) throws SQLException{
		return storeOwner.GetTheMostViewedProduct(storeID,storeType);
	}
	
	public void UpdateProduct(String storeID, String productID, Double price, Integer quantaty, Double discount) throws SQLException {

	}

	public void DeleteProduct(String storeID, String productID) throws SQLException{
		
	}

	public void DeleteStore(String StoreID) throws SQLException {
		
	}

	public void UpdateStore() throws SQLException {
	  
	}

//  public Stat GetStat(){
//	  return null;
//  }

}