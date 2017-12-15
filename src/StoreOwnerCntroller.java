public interface StoreOwnerCntroller {

  public String AddProduct(String storeID, String productID, Double price, Integer quantaty, Double discount);

  public String UpdateProduct(String storeID, String productID, Double price, Integer quantaty, Double discount);

  public String DeleteProduct(String storeID, String productID);

  public String DeleteStore(String StoreID);

  public String AddStore( //kamelha);

  public String UpdateStore( //kamelha);

  public Stat GetStat();

}