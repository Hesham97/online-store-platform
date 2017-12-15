package onlineStore;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
	StoreOwnerDBHandler dbHandler= new StoreOwnerDBHandler();
	try {
		dbHandler.createOnlineStore("hamda", "aaa");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
