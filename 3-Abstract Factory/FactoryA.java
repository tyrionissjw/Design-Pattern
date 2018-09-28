public class FactoryA extends AbstractFactory {
   public ProductA createProductA() {
         return new ConcreateProductA1();
   }
   
   public ProductB createProductB() {
        return new ConcreateProductB1();
   }
   
   public static AbstractFactory newInstance() {
          return new FactoryA();
   }
}
