package onlineStore;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
	ProductDBHandler dbHandler= new ProductDBHandler();
	try {
		dbHandler.addProduct("20150290","HZW",290,1,100,"F50","hamda");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
