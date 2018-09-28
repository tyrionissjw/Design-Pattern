public abstract class ProductWithFactory {
     public abstract void business();
	 //简单工厂变形:工厂方法位于抽象产品
	 public static ProductWithFactory factory() {
	    return new ConcreateProduct1();
	 }
}