package onlineStore;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreOwner {

	public String name;
	
	public String userName;

	public String phoneNumber;

	public String address;
	
	public String password;
  
	public Boolean premium;

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
		balance = storeOwner.balance;
		return true;
	}
	
	
	public void AddProductToOnlineStore(String storeID, String productID, float price, int quantaty, float discount) throws SQLException {
		productDBHandler.addOnlineProduct(productID, price, quantaty, discount, storeID);
	}
	
	public void AddProductToOfflineStore(String storeID, String productID, float price, int quantaty, float discount) throws SQLException {
		productDBHandler.addOflineProduct(productID, price, quantaty, discount, storeID);
	}
	
	public void AddOnlineStore(String name,String storeOwnerUserName) throws SQLException {
		storeOwnerDBHandler.createOnlineStore(name, storeOwnerUserName);
	}
	
	public void AddOfflineStore(String name,String address , String storeOwnerUserName) throws SQLException {
		storeOwnerDBHandler.createOffilneStore(name, storeOwnerUserName, address);
	}
	
	public ArrayList<Product> GetAllProducts() throws SQLException {
		return productDBHandler.getProducts();
	}
	
	public ArrayList<Product> getProducts(String storeID,boolean storeType) throws SQLException {
		ArrayList<Product> products = null;
		if(!storeType)
			products=productDBHandler.onlineStoreProducts (storeID);
		else
			products=productDBHandler.offlineStoreProducts (storeID);
		return products;
	}
	
	public ArrayList<Product> GetTheMostViewedProduct (String storeID,boolean storeType)  throws SQLException {
		ArrayList<Product> products = getProducts(storeID,storeType);
		ArrayList<Product> returnProducts = new ArrayList<Product>();
		
		if(products != null) {
			int index = -1;
			for(int i = 0 ; i < products.size() ; i++) {
				if(index == -1 || products.get(i).numberOfViews > products.get(index).numberOfViews) {
					index = i;
				}
			}
			
			for(int i = 0 ; i < products.size() ; i++) {
				if(products.get(i).numberOfViews == products.get(index).numberOfViews) {
					returnProducts.add(products.get(i));
				}
			}
		}else
			returnProducts = null;
		return returnProducts;
	}
	
	public void UpdateProduct(String storeID, String productID, Double price, Integer quantaty, Double discount) throws SQLException {}
	
	public void DeleteProduct(String storeID, String productID) throws SQLException {}

	public void DeleteStore(String StoreID) throws SQLException {}

	public void UpdateStore() throws SQLException {}
}