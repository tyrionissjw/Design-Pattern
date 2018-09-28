public abstract class AbstractFactory {
   public abstract ProductA createProductA();
   public abstract ProductB createProductB();
   public static AbstractFactory createFactory(int param) {
         if (param == 1) {
		     return new FactoryA();
		 } if (param ==2) {
		     return new FactoryB();
		 } if (param ==3) {
		     return new FactoryC();
		 }
		 throw new IllegalArgumentException("参数无效");
   }
}