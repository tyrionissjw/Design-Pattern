public class FactoryC extends AbstractFactory {
   public ProductA createProductA() {
         return new ConcreateProductA3();
   }
   
   public ProductB createProductB() {
        return new ConcreateProductB3();
   }
   
   public static AbstractFactory newInstance() {
        return new FactoryC();
   }
}

