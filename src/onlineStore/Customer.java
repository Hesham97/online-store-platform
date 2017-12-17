package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

	public String firstName;
	
	public String secondName;
	
	public String userName;
	
	public String email;
	
	public String password;
	
	public String phoneNumber;
	
	public String cartID;

	CustomerDBHandler customerDBHandler = new CustomerDBHandler();
	ProductDBHandler productDBHandler = new ProductDBHandler();
	
  	public boolean SignIn(String identifier, String password) throws SQLException {
  		Customer customer = null;
  		if(validate(identifier))
  			customer = customerDBHandler.SignInByEmail(identifier , password);
  		else
  			customer = customerDBHandler.SignInByUserName(identifier , password);
  		
  		if(customer == null)
			return false;
  		
  		email = customer.email;
  		userName = customer.userName;
  		password = customer.password;
  		firstName = customer.firstName;
  		secondName = customer.secondName;
  		phoneNumber = customer.phoneNumber;
  		cartID = customer.cartID;
  		return true;
  	}
  	
  	public void SignUp(String _firstName, String _secondName, String _userName, String _email, String _password,
			String _phoneNumber) throws SQLException {
  		customerDBHandler.addCustomer(_firstName, _userName, _secondName,_email,_password,_phoneNumber);
	}
  	
  	public ArrayList<Product> getProducts(String storeID,boolean storeType) throws SQLException {
		ArrayList<Product> products = null;
		if(!storeType)
			productDBHandler.onlineStoreProducts (storeID);
		else
			productDBHandler.offlineStoreProducts (storeID);
		return products;
	}
  	
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    		Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
    	 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
    	 return matcher.find();
    }

	
  	public Integer AddToCart(String ProductID) {return null;}

  	public Integer AddReview(String review, String productID) {return null;}

  	public Integer ChangePassword(String oldPassword, String newPassword) {return null;}

  	public Integer Buy(String[] productID) {return null;}

  	//private Integer SelectPaymentMethod(String methodID, Double price) {return null;}

  	public Boolean PayWithCash(Double price) {return null;}

  	public Boolean PayWithVisa(Double price) {return null;}

  	public Boolean PayWithV(Double price) {return null;}

//  	public Cart ViewCart() {return null;}		
//  	public void SignUp() {}

}