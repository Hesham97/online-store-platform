package onlineStore;

public class Main {

	public static void main(String[] args) {
		SingletonDB db = SingletonDB.getDB();
		db.act();
	}

}
