package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
	
	customertController _customertController = new customertController();
	
	public Boolean ViewCustomer() {
		int in;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			if(_customertController == null) {
				System.out.println("1. signin\n2. close");
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
				System.out.println("1. Explore products in store\n6. signout");
				in = input.nextInt();
				if(in == 1) {
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
				}else if(in == 6){
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
}
