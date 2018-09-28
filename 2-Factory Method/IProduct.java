public class IProduct implements Product {
   public IProduct() {
   }
   
   public IProduct(String s) {
        System.out.println("IProduct "+s);
   }
      
   public void business() {
        System.out.println("this is IProduct business");
   }        
}