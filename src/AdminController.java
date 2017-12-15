public interface AdminController {

  public void SignIn(String name, String Password);

  public String AddProduct(String name, String BrandID, String category);

  public String DeleteProduct(String ProductID);

  public String RemoveStore(String StoreID);

  public String BlockStoreOwner( StoreOwnerID);

  public Stat ShowStat();

  public String BlockUser(String CustomerName);

}