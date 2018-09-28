public class Main {
   // 抽象工厂就是"抽象产品角色的工厂"
   // 它与工厂方法的最大区别:前者针对多个产品等级结构，后者只针对一个产品等级结构   
   // 抽象工厂类可以配备静态方法，返回具体工厂实例
   // 具体工厂类可以配备一个静态方法，返回具体工厂类自己
   /*
    java.awt库中，一套java构建是与操作系统无关的，另一套是与底层操作系统有关的Peer构件
	java.awt.ToolKit这个抽象类为不同的操作系统提供Peer构件创建的工厂类(相当于抽象工厂)
	而java构件是通过Tookit类与Peer构件通信(桥梁模式)
   */
   public static void main(String[] args) {
        //IllegalArgument
        AbstractFactory.createFactory(4);
        AbstractFactory a1 = AbstractFactory.createFactory(1);
		AbstractFactory b1 = AbstractFactory.createFactory(2);
		AbstractFactory c1 = AbstractFactory.createFactory(3);				
		a1.createProductA();
		a1.createProductB();
		b1.createProductA();
		b1.createProductB();
		c1.createProductA();
		c1.createProductB();
		
		AbstractFactory a2 = FactoryA.newInstance();
		AbstractFactory b2 = FactoryB.newInstance();
		AbstractFactory c2 = FactoryC.newInstance();
		
		
		
		
   }
}