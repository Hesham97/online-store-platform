package onlineStore;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreOwner {

	public String name;
	
	public String userName;

	public String phoneNumber;

	public String address;
	
	public String password;
  
	public Boolean premium;

	public List<String> storeList;

	public Double balance;
	
	StoreOwnerDBHandler storeOwnerDBHandler = new StoreOwnerDBHandler();
	ProductDBHandler productDBHandler = new ProductDBHandler(); 
	
	public void SignUp(String _name ,String _userName ,String _password , String _phoneNumber , String _address , String _premium)  throws SQLException {
		storeOwnerDBHandler.SignUp(_name ,_userName,_password,_phoneNumber,_address,_premium);
	}
	
	public boolean SignIn(String _userName ,String _password) throws SQLException {
		StoreOwner storeOwner = storeOwnerDBHandler.SignIn(_userName ,_password);
		if(storeOwner == null)
			return false;
		name = storeOwner.name;
		phoneNumber = storeOwner.phoneNumber;
		address = storeOwner.address;
		premium = storeOwner.premium;
		storeList = storeOwner.storeList;
		balance = storeOwner.balance;
		return true;
	}
	
	public void AddProductToOnlineStore(String storeID, String productID, Double price, Integer quantaty, Double discount) throws SQLException {
		productDBHandler.addOnlineProduct(productID, price, quantaty, discount, storeID);
	}
	
	public void AddProductToOfflineStore(String storeID, String productID, Double price, Integer quantaty, Double discount) throws SQLException {
		productDBHandler.addOfflineProduct(productID, price, quantaty, discount, storeID);
	}
	
	public void AddOnlineStore(String name,String storeOwnerUserName) throws SQLException {
		storeOwnerDBHandler.createOnlineStore(name, storeOwnerUserName);
	}
	
	public void AddOfflineStore(String name,String address , String storeOwnerUserName) throws SQLException {
		storeOwnerDBHandler.createOffilneStore(name, storeOwnerUserName, address);
	}
	
	public ArrayList<Product> GetAllProducts(){
		return null;   //nadi 3la el data base
	}
	
	public void UpdateProduct(String storeID, String productID, Double price, Integer quantaty, Double discount) throws SQLException {
		
	}
	
	public void DeleteProduct(String storeID, String productID) throws SQLException {
		
	}

	public void DeleteStore(String StoreID) throws SQLException {
		
	}

	public void UpdateStore() throws SQLException {
		
	}

//  public Stat GetStat() {
//  return null;
//  }

}