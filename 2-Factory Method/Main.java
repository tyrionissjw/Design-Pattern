public class Main {
   // 工厂方法相比简单工厂的好处：增加新的产品无需修改具体工厂类，只需增加一个工厂类。
   // 可以在抽象工厂中加入不同的工厂方法，用以创建不同形式的相同产品。
   /*
     COM框架中的工厂方法：
	    1.用户调用Com库函数CoCreateInstance,它以CoGetClassObject实现
		2.CoCreateInstance在Register中寻找所需的Component,找到的话加载它的DLL
		3.CoGetClassObject调用DllGetClassObject，后者实例化CFactory(具体工厂类)
		4.DllGetClassObject会向工厂类CFactory查询其接口IClassFactory(抽象工厂)，并返回给CoCreateInstance
		5.CoCreateInstance调用IClassFactory的CreateInstance函数创建需要的Component
   */
   public static void main(String[] args) {
       TopFactory tf = new IFactory();
	   Product p1 = tf.createProduct1();
	   Product p2 = tf.createProduct2();
	   
	   MiddleFactory mf = new IMiddleFactory();
	   Product middlep1 =  mf.createProduct1();
	   Product middlep2  = mf.createProduct2();
       MiddleProduct middlep3 = mf.createMiddleProduct();	   	   
   }
}