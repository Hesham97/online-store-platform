package onlineStore;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		while(true) {
			System.out.println("1. admin\n2. store owner\n3. customer\n4. Quit");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int in = input.nextInt();
			if(in == 1) {
				AdminView admin = new AdminView();
				while(admin.ViewAdmin());
			}else if(in == 2) {
				StoreOwnerView storeOwner = new StoreOwnerView();
				while(storeOwner.ViewStoreOwner());
			}else if(in == 3) {
//				CustomerView customer = new CustomerView();
//				while(customer.ViewCustomer());
			}else if(in == 4){
				return;
			}else {
				System.out.println("wrong input");
			}
		}
	}
}
