public class FactoryB extends AbstractFactory {
   public ProductA createProductA() {
         return new ConcreateProductA2();
   }
   
   public ProductB createProductB() {
        return new ConcreateProductB2();
   }
   
   public static AbstractFactory newInstance() {
          return new FactoryB();
   }
}
