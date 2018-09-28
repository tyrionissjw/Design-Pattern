public class ConcreateProduct3  implements Product {
   public ConcreateProduct3() {
   }
   //简单工厂变形:工厂方法位于具体产品
   public static Product factory() {
      return new ConcreateProduct3();   
   }
   public void business() {
     System.out.println("商业方法3调用");
   }
}