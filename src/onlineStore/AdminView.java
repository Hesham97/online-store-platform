package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminView {
	
	AdminController adminController = new AdminController();
	
	public Boolean ViewAdmin() {
		int in;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			if(adminController == null) {
				System.out.println("1. signin\n2. close");
				in = input.nextInt();
				if(in == 1) {
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
				System.out.println("1. add brand\n2. add product\n3. remove product\n4. remove store\n"
						+ "5. block store owner\n6.block user\n7. signout");
				in = input.nextInt();
				if(in == 1) {
					System.out.print("Input brand name : ");
					String brandName;
					brandName = input.next();
					System.out.print("Input company name : ");
					String companyName;
					companyName = input.next();
					adminController.AddBrand(brandName, companyName);
				}else if(in == 2) {
					System.out.print("Input name : ");
					String name;
					name = input.next();
					System.out.print("Input product ID : ");
					String productID;
					productID = input.next();
					System.out.print("Input brand : ");
					String brand;
					brand = input.next();
					System.out.print("Input category : ");
					String category;
					category = input.next();
					adminController.AddProduct(name , productID , brand, category);
				}else if(in == 3) {
					System.out.print("Input product ID : ");
					String productID;
					productID = input.next();
					adminController.DeleteProduct(productID);
				}else if(in == 4) {
					System.out.print("Input store ID : ");
					String storeID;
					storeID = input.next();
					adminController.RemoveStore(storeID);
				}else if(in == 5) {
					System.out.print("Input store owner ID : ");
					String storeOwnerID;
					storeOwnerID = input.next();
					adminController.BlockStoreOwner(storeOwnerID);
				}else if(in == 6) {
					System.out.print("Input customer name : ");
					String customerName;
					customerName = input.next();
					adminController.BlockUser(customerName);
				}else if(in == 7){
					return false;
				}else{
					System.out.println("Wrong input !");
				}
			}
		}catch(SQLException e) {
			System.out.println("some thing went wrong");
		}
		return true;
	}
}
