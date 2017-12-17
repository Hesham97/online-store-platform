package onlineStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class productController {

	ProductDBHandler productDBHandler = new ProductDBHandler();
	
	public ArrayList<Product> Search(float price, String brandID, String category, String name) throws SQLException {
		ArrayList<Product> product = null;
		ArrayList<Product> productprice = null;
		ArrayList<Product> productbrand = null;
		ArrayList<Product> productcategory = null;
		ArrayList<Product> productname = null;
		
		boolean start = false;
		
		if(brandID != "") {
			productbrand = productDBHandler.getProductByBrand(brandID);
			SortByID(productbrand);
			if(!start) {
				product = productbrand;
			}
			start = true;
		}
		if(price != -1) {
			productprice = productDBHandler.getProductByPrice(price);
			SortByID(productprice);
			if(!start) {
				product = productprice;
			}else {
				
			}
			start = true;
		}
		if(category != "") {
			productcategory = productDBHandler.getProductByCategory(category);
			SortByID(productcategory);
			if(!start) {
				product = productcategory;
			}else {
				
			}
			start = true;
		}
		if(name != "") {
			productname = productDBHandler.getProductByName(name);
			SortByID(productname);
			if(!start) {
				product = productname;
			}else {
				
			}
			start = true;
		}
	
		return product;
	}
	
	private void AddExist(ArrayList<Product> from ,ArrayList<Product> to) {
		for(int i = 0 ; i < from.size() ; i++) {
			for(int j = 0 ; j < to.size() ; j++) {
				if(from.get(i).productID == to.get(j).productID)
				{
					to.remove(j);
					break;
				}
			}
		}
	}
	
	private void SortByID(ArrayList<Product> list) {
		for(int i = 0 ; i < list.size() ;i++) {
			for(int j = i ; j< list.size() ; j++) {
				if(list.get(i).productID.compareTo(list.get(j).productID) > 0 || list.get(j).tybe){
					Product temp = list.get(i);
					list.set(i,list.get(j));
					list.set(j,temp);
				}
			}
		}
	}
//
//  public Product ViewProduct(String prouctID);
//
//  public Void Compare(String productID_1, String productID_2);

}