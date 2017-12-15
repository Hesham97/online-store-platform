package onlineStore;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
	AdminDBHandler dbHandler= new AdminDBHandler();
	try {
		dbHandler.addBrand("f50", "abbibas");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
