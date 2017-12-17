package onlineStore;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminView {
	
	AdminController adminController = null;
	
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
				System.out.println("1. add brand\n2. add product\n3. remove product\n4. remove store\n"
						+ "5. block store owner\n6. block user\n7. add voucher card\n8. provide voucher cards\n9. signout");
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
				}else if(in == 3) {
					System.out.print("Enter the product ID : ");
					String productID;
					productID = input.next();
					adminController.DeleteProduct(productID);
				}else if(in == 4) {
					System.out.print("Enter the store ID : ");
					String storeID;
					storeID = input.next();
					adminController.RemoveStore(storeID);
				}else if(in == 5) {
					System.out.print("Enter the store owner ID : ");
					String storeOwnerID;
					storeOwnerID = input.next();
					adminController.BlockStoreOwner(storeOwnerID);
				}else if(in == 6) {
					System.out.print("Enter the customer name : ");
					String customerName;
					customerName = input.next();
					adminController.BlockUser(customerName);
				}else if(in == 7){
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
				}else if(in == 8) {
					System.out.print("Enter the serial number : ");
					String serialNumber;
					serialNumber = input.next();
					System.out.print("Enter the customer user name : ");
					String customerUseName;
					customerUseName = input.next();
					adminController.assignVoucher(serialNumber, customerUseName);
				}else if(in == 9){
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
}
