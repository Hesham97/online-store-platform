package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
	
	customertController _customertController = null;
	productController _productController = new productController();
	
	public Boolean ViewCustomer() {
		int in;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			if(_customertController == null) {
				System.out.println("1. signin\n2. signup\n3. close");
				in = input.nextInt();
				if(in == 1) {
					_customertController = new customertController();
					System.out.println("Enter the name : ");
					String name = input.next();
					System.out.println("Enter the password : ");
					String Password = input.next();
					if(!_customertController.SignIn(name, Password)) {
						_customertController = null;
						System.out.println("wrong name or password!");
					}
				}else if (in == 2) {
					System.out.println("Enter the first name : ");
					String firstName = input.next();
					System.out.println("Enter the user second name : ");
					String secondName = input.next();
					System.out.println("Enter the user user name : ");
					String userName = input.next();
					System.out.println("Enter the user email : ");
					String email = input.next();
					System.out.println("Enter the user password : ");
					String password = input.next();
					System.out.println("Enter the phone number : ");
					String phoneNumber = input.next();
					_customertController = new customertController();
					_customertController.SignUp(firstName, secondName, userName, email, password, phoneNumber);
					_customertController = null;
				} else if (in == 3) {
					return false;
				} else {
					System.out.println("Wrong input !");
				}
			}else {
				System.out.println("1. Explore products in store\n2. View specific product details\n"
						+ "3. Suggest product\n4. signout");
				in = input.nextInt();
				if(in == 1) {
					System.out.println("Online stores");
					Printonstore(_customertController.getonlineStores());
					System.out.println("Offline stores");
					Printoffstore(_customertController.getStores());
					int type;
					do {
						System.out.println("1. online store\n2. offline store");
						type = input.nextInt();
						if(type > 2 || type < 1)
							System.out.println("wrong input");
					}while(type > 2 || type < 1);
					System.out.println("Enter the store ID : ");
					String storeID = input.next();
					ArrayList<Product> products = _customertController.getProducts(storeID,(type == 1)?false:true);
					PrintProducts(products);
				}else if(in == 2){
					System.out.println("Enter the price \n-1 for skip: ");
					float price = input.nextFloat();
					System.out.println("Enter the brand ID \n-1 for skip:  ");
					String brandID = input.next();
					if(brandID.equals("-1")) brandID = "";
					System.out.println("Enter the category \n-1 for skip:  ");
					String category = input.next();
					if(category.equals("-1")) category = "";
					System.out.println("Enter the name \n-1 for skip:  ");
					String name = input.next();
					if(name.equals("-1")) name = "";
					ArrayList<Product> products = _productController.Search(price, brandID, category, name);
					PrintProducts(products);
				}else if(in == 3){
					System.out.println("Enter the product name : ");
					String productName = input.next();
					System.out.println("Enter the product ID : ");
					String productID = input.next();
					System.out.println("Enter the brand : ");
					String brand = input.next();
					System.out.println("Enter the category : ");
					String category = input.next();
					int type;
					do {
						System.out.println("1. online store\n2. offline store");
						type = input.nextInt();
						if(type > 2 || type < 1)
							System.out.println("wrong input");
					}while(type > 2 || type < 1);
					_productController.SuggestProduct(productName,productID,brand,category,(type == 1)?false:true);
				}else if(in == 4){
					return false;
				}else{
					System.out.println("Wrong input !");
				}
			}
		}catch(SQLException e) {
			System.out.println("some thing went wrong");
			_customertController = null;
		}
		return true;
	}
	
	void PrintProducts(ArrayList<Product> products) {
		if(products == null){
			System.out.println("there is no products");
			return;
		}
		for (int i = 0; i < products.size(); i++) {
			System.out.println("product id : " + products.get(i).productID + " ,name : " + products.get(i).name
					+ " ,category : " + products.get(i).category);
		}
	}
	
	void Printoffstore(ArrayList<OfflineStore> store) {
		if(store == null){
			System.out.println("there is no offline stores");
			return;
		}
		for (int i = 0; i < store.size(); i++) {
			System.out.println("store id : " + store.get(i).name);
		}
	}
	
	void Printonstore(ArrayList<OnlineStore> store) {
		if(store == null){
			System.out.println("there is no online stores");
			return;
		}
		for (int i = 0; i < store.size(); i++) {
			System.out.println("store id : " + store.get(i).name);
		}
	}
}
