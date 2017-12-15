public interface productController {

  public Product[] Search(Double price, String brandID, String category, String name, Boolean bestsales);

  public Product ViewProduct(String prouctID);

  public Void Compare(String productID_1, String productID_2);

}