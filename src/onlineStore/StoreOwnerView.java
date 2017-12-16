package onlineStore;

import java.util.Scanner;

public class StoreOwnerView {
	
	StoreOwnerCntroller storeOwnerCntroller = null;
	
	public void ViewStoreOwner(){
		int in;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		if(storeOwnerCntroller == null) {
			System.out.println("1. signin");
			in = input.nextInt();
			if(in == 1) {
				System.out.println("Enter the name : ");
				String name = input.next();
				System.out.println("Enter the password : ");
				String Password = input.next();
				if(!storeOwnerCntroller.SignIn(name, Password)) {
					storeOwnerCntroller = null;
					System.out.println("wrong name or password!");
				}
			}else {
				System.out.println("Wrong input !");
			}
		}
	}
}
