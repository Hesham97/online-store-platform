public interface customertController {

  public String AddToCart(String ProductID);

  public String SignIn(String identifier, String password);

  public void Signout();

  public String AddReview(String review, String productID);

  public String ChangePassword(String oldPassword, String newPassword, String confirmNewPassword);

  public void Search(Double price);

  public String Buy(String[] productId);

  public Cart ViewCart();

  public String SelectPaymentMethod(String MethodID, Double price);

  public void SignUp( //);

}