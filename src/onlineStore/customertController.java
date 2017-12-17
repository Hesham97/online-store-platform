package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class customertController {
	Customer customer = new Customer();

  	public boolean SignIn(String identifier, String password) throws SQLException{
		return customer.SignIn(identifier, password);
  	}

  	public void SignUp(String firstName,String secondName,String userName,String email,String password,String phoneNumber) throws SQLException {
  		customer.SignUp(firstName,secondName,userName,email,password,phoneNumber);
  	}
  	
  	public ArrayList<Product> getProducts(String storeID, boolean type) throws SQLException {
  		return customer.getProducts(storeID, type);
  	};
  	
  public String AddToCart(String ProductID){return null;}

  public String AddReview(String review, String productID){return null;}

  public String ChangePassword(String oldPassword, String newPassword, String confirmNewPassword){return null;}

  public void Search(Double price) {}

  public String Buy(String[] productId){return null;}

  public String SelectPaymentMethod(String MethodID, Double price){return null;}

  public void SignUp() {}


//public Cart ViewCart() {
//		return null;}
}