public class Main {
   //当产品结构复杂时，使用一个工厂创建不同产品。优点：工厂结构不变，只有一个工厂类。缺点：工厂方法变化
   //由于简单工厂使用静态方法，无法继承。因此工厂角色无法形成等级结构。
   public static void main(String[] args) {
        Product p = CommonFactory.factory();
		p.business();
		ProductWithFactory p1 = ProductWithFactory.factory();
		p1.business();
		Product p2 = ConcreateProduct3.factory();
		p2.business();
   }
}