package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
	
	AdminController adminController = null;
	productController _productController = new productController();
	
	public Boolean ViewAdmin() {
		int in;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			if(adminController == null) {
				
				System.out.println("1. signin\n2. close");
				in = input.nextInt();
				if(in == 1) {
					adminController = new  AdminController();
					System.out.println("Enter the name : ");
					String name = input.next();
					System.out.println("Enter the password : ");
					String Password = input.next();
					if(!adminController.SignIn(name, Password)) {
						adminController = null;
						System.out.println("wrong name or password!");
					}
				}else if(in == 2){
					return false;
				}else {
					System.out.println("Wrong input !");
				}
			}else {
				System.out.println("1. add brand\n2. add product\n"
						+ "3. add voucher card\n4. provide voucher cards\n"
						+ "5. Explore products in store\n6. View specific product details\n7. signout");
				in = input.nextInt();
				if(in == 1) {
					System.out.print("Enter the brand name : ");
					String brandName;
					brandName = input.next();
					System.out.print("Enter the company name : ");
					String companyName;
					companyName = input.next();
					adminController.AddBrand(brandName, companyName);
				}else if(in == 2) {
					System.out.print("Enter the name : ");
					String name;
					name = input.next();
					System.out.print("Enter the product ID : ");
					String productID;
					productID = input.next();
					System.out.print("Enter the brand : ");
					String brand;
					brand = input.next();
					System.out.print("Enter the category : ");
					String category;
					category = input.next();
					int type;
					do {
						System.out.println("1. online store\n2. offline store");
						type = input.nextInt();
						if(type > 2 || type < 1)
							System.out.println("wrong input");
					}while(type > 2 || type < 1);
					adminController.AddProduct(name , productID , brand, category,(type == 1)?false:true);
				}else if(in == 3){
					String serialNumber;
					do {
						System.out.print("Enter the serial number : ");
						serialNumber = input.next();
					}while(serialNumber.length()<0 || serialNumber.length()>6);
					System.out.print("Enter the value : ");
					float value;
					value = input.nextFloat();
					System.out.print("Enter the quantity : ");
					int quantity;
					quantity = input.nextInt();
					adminController.AddVoucherCard(serialNumber,value,quantity);
				}else if(in == 4) {
					System.out.print("Enter the serial number : ");
					String serialNumber;
					serialNumber = input.next();
					System.out.print("Enter the customer user name : ");
					String customerUseName;
					customerUseName = input.next();
					adminController.assignVoucher(serialNumber, customerUseName);
				}else if(in == 5){
					int type;
					do {
						System.out.println("1. online store\n2. offline store");
						type = input.nextInt();
						if(type > 2 || type < 1)
							System.out.println("wrong input");
					}while(type > 2 || type < 1);
					System.out.println("Enter the store ID : ");
					String storeID = input.next();
					ArrayList<Product> products = adminController.getProducts(storeID,(type == 1)?false:true);
					PrintProducts(products);
				}else if(in == 6){
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
				}else if(in == 7){
					return false;
				}else{
					System.out.println("Wrong input !");
				}
			}
		}catch(SQLException e) {
			System.out.println("some thing went wrong");
			adminController = null;
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
