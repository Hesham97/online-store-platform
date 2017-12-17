package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreOwnerView {

	StoreOwnerCntroller storeOwnerCntroller = null;
	productController _productController = new productController();

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
					System.out.println("Enter the Premium : ");
					int type;
					do {
						System.out.println("1. for Premium\n2. Normal Account");
						type = input.nextInt();
						if(type > 2 || type < 1)
							System.out.println("wrong input");
					}while(type > 2 || type < 1);
					storeOwnerCntroller = new StoreOwnerCntroller();
					storeOwnerCntroller.SignUp(_name, _userName, _password, _phoneNumber, _address, String.valueOf((type==1)?1:0));
					storeOwnerCntroller = null;
				} else if (in == 3) {
					return false;
				} else {
					System.out.println("Wrong input !");
				}
			} else {
				System.out.println("1. Add product to online store\n2.add product to offline store"
						+ "\n3. add online store\n4. add offline store\n"
						+ "5. Explore number of views to each product in a store 'premium only'\n"
						+ "6. Get the most viewed product 'premium only'\n"
						+ "7. Explore products in store\n8. View specific product details\n9. Suggest product"
						+ "\n10. signout");
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
							if (price < discount)
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
					if(storeOwnerCntroller.IsPremium()) {
						int type;
						do {
							System.out.println("1. online store\n2. offline store");
							type = input.nextInt();
							if(type > 2 || type < 1)
								System.out.println("wrong input");
						}while(type > 2 || type < 1);
						System.out.println("Enter the store ID : ");
						String storeID = input.next();
						ArrayList<Product> products = storeOwnerCntroller.getProducts(storeID,(type == 1)?false:true);
						PrintProductsWithViews(products);
					}else
						System.out.println("you are not premium");
				} else if (in == 6) {
					if(storeOwnerCntroller.IsPremium()) {
						int type;
						do {
							System.out.println("1. online store\n2. offline store");
							type = input.nextInt();
							if(type > 2 || type < 1)
								System.out.println("wrong input");
						}while(type > 2 || type < 1);
						System.out.println("Enter the store ID : ");
						String storeID = input.next();
						ArrayList<Product> products = storeOwnerCntroller.GetTheMostViewedProduct(storeID,(type == 1)?false:true);
						PrintProductsWithViews(products);
					}else
						System.out.println("you are not premium");
				} else if (in == 7) {
					int type;
					do {
						System.out.println("1. online store\n2. offline store");
						type = input.nextInt();
						if(type > 2 || type < 1)
							System.out.println("wrong input");
					}while(type > 2 || type < 1);
					System.out.println("Enter the store ID : ");
					String storeID = input.next();
					ArrayList<Product> products = storeOwnerCntroller.getProducts(storeID,(type == 1)?false:true);
					PrintProducts(products);
				} else if(in == 8) {
					System.out.println("Enter the price : ");
					float price = input.nextInt();
					System.out.println("Enter the brand ID : ");
					String brandID = input.next();
					System.out.println("Enter the category : ");
					String category = input.next();
					System.out.println("Enter the name : ");
					String name = input.next();
					ArrayList<Product> products = _productController.Search(price, brandID, category, name);
					PrintProducts(products);
				}else if(in == 9){
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
				}else if (in == 10) {
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
		if(products == null){
			System.out.println("there is no products");
			return;
		}
		for (int i = 0; i < products.size(); i++) {
			System.out.println("product id : " + products.get(i).productID + " ,name : " + products.get(i).name
					+ " ,category : " + products.get(i).category);
		}
	}

	void PrintProductsWithViews(ArrayList<Product> products) {
		if(products == null){
			System.out.println("there is no products");
			return;
		}
		for (int i = 0; i < products.size(); i++) {
			System.out.println("product id : " + products.get(i).productID + " ,name : " + products.get(i).name
					+ " ,category : " + products.get(i).category + ", Views : " + products.get(i).numberOfViews);
		}
	}
}
