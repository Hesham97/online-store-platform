package onlineStore;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
	ProductDBHandler dbHandler= new ProductDBHandler();
	try {
		dbHandler.updateViewOnlineStore("20150290hamda");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
