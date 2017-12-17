package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreOwnerView {

	StoreOwnerCntroller storeOwnerCntroller = null;

	public Boolean ViewStoreOwner() {
		int in;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			if (storeOwnerCntroller == null) {
				System.out.println("1. signin\n2. signUp\n3. close");
				in = input.nextInt();
				if (in == 1) {
					storeOwnerCntroller = new StoreOwnerCntroller();
					System.out.println("Enter the user name : ");
					String name = input.next();
					System.out.println("Enter the password : ");
					String Password = input.next();
					if (!storeOwnerCntroller.SignIn(name, Password)) {
						storeOwnerCntroller = null;
						System.out.println("wrong user name or password!");
					}
				} else if (in == 2) {
					System.out.println("Enter the user name : ");
					String _name = input.next();
					System.out.println("Enter the user user name : ");
					String _userName = input.next();
					System.out.println("Enter the user password : ");
					String _password = input.next();
					System.out.println("Enter the user phone number : ");
					String _phoneNumber = input.next();
					System.out.println("Enter the user address : ");
					String _address = input.next();
					System.out.println("Enter the premuim : ");
					String _premuim = input.next();
					storeOwnerCntroller = new StoreOwnerCntroller();
					storeOwnerCntroller.SignUp(_name, _userName, _password, _phoneNumber, _address, _premuim);
					storeOwnerCntroller = null;
				} else if (in == 3) {
					return false;
				} else {
					System.out.println("Wrong input !");
				}
			} else {
				System.out.println("1. Add product to online store\n2.add product to offline store"
						+ "\n3. add online store\n4. add offline store\n"
						+ "5. Explore number of views to each product in a store\n"
						+ "6. Get the most viewed product\n7. signout");
				in = input.nextInt();
				if (in == 1) {
					ArrayList<Product> systemProduct = storeOwnerCntroller.GetAllProducts();
					PrintProducts(systemProduct);
					while (true) {
						System.out.println("Enter the store ID : ");
						String storeID = input.next();
						System.out.println("Enter the product ID : ");
						String productID = input.next();
						float price;
						float discount;
						do {
							System.out.println("Enter the price : ");
							price = input.nextFloat();
							System.out.println("Enter the discount : ");
							discount = input.nextFloat();
							if (price >= discount)
								System.out.println("discount if bigger than the price");
						} while (price < discount);
						System.out.println("Enter the quantaty : ");
						int quantaty = input.nextInt();
						storeOwnerCntroller.AddProductToOnlineStore(storeID, productID, price, quantaty, discount);
						System.out.println("1. Enter another product\n2. Quit");
						in = input.nextInt();
						if (in == 2)
							break;
					}
				} else if (in == 2) {
					ArrayList<Product> systemProduct = storeOwnerCntroller.GetAllProducts();
					PrintProducts(systemProduct);
					while (true) {
						System.out.println("Enter the store ID : ");
						String storeID = input.next();
						System.out.println("Enter the product ID : ");
						String productID = input.next();
						System.out.println("Enter the price : ");
						float price = input.nextFloat();
						System.out.println("Enter the quantaty : ");
						int quantaty = input.nextInt();
						System.out.println("Enter the discount : ");
						float discount = input.nextFloat();
						storeOwnerCntroller.AddProductToOfflineStore(storeID, productID, price, quantaty, discount);
						System.out.println("1. Enter another product\n2. Quit");
						in = input.nextInt();
						if (in == 2)
							break;
					}
				} else if (in == 3) {
					System.out.println("Enter the name : ");
					String name = input.next();
					System.out.println("Enter the store owner user name : ");
					String storeOwnerUserName = input.next();
					storeOwnerCntroller.AddOnlineStore(name, storeOwnerUserName);
				} else if (in == 4) {
					System.out.println("Enter the name : ");
					String name = input.next();
					System.out.println("Enter the address : ");
					String address = input.next();
					System.out.println("Enter the store owner user name : ");
					String storeOwnerUserName = input.next();
					storeOwnerCntroller.AddOfflineStore(name, address, storeOwnerUserName);
					;
				} else if (in == 5) {
					System.out.println("Enter the store ID : ");
					String storeID = input.next();
					ArrayList<Product> products = storeOwnerCntroller.getProducts(storeID);
					PrintProductsWithViews(products);
				} else if (in == 6) {
					System.out.println("Enter the store ID : ");
					String storeID = input.next();
					ArrayList<Product> products = storeOwnerCntroller.GetTheMostViewedProduct(storeID);
					PrintProductsWithViews(products);
				} else if (in == 7) {
					return false;
				} else {
					System.out.println("Wrong input !");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("some thing went wrong");
			storeOwnerCntroller = null;
		}
		return true;
	}

	void PrintProducts(ArrayList<Product> products) {
		for (int i = 0; i < products.size(); i++) {
			System.out.println("product id : " + products.get(i).productID + " ,name : " + products.get(i).name
					+ " ,category : " + products.get(i).category);
		}
	}

	void PrintProductsWithViews(ArrayList<Product> products) {
		for (int i = 0; i < products.size(); i++) {
			System.out.println("product id : " + products.get(i).productID + " ,name : " + products.get(i).name
					+ " ,category : " + products.get(i).category + ", Views : " + products.get(i).numberOfViews);
		}
	}
}
