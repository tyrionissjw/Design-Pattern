import java.util.*;
/*
	 1.作用：通过给出一个原型对象来指明所需要创建的类型，然后用复制这个原型对象
		 的方法创建更多同类型对象
	 2.假设产品等级结构式动态变化的。若使用工厂模式，则工厂结构也变化。此时可使用原型模式
	 3.原型模式与门面模式的关系:原型模式的客户端通常可以将系统的其他对象与参与原型模式的对象分隔开，
		起到一个门面作用
*/
public class Main {
	 public static void main(String[] args) {
		 // java中简单原型模式-clone
		 Date prototype = new Date();
		 Date cloneD = prototype.clone();
		 /*
			 使用串行化实现原型模式
			 1.对一个对象实施串行化导致这个对象所引用的对象和原始类型同时受到串行化。
				 当并行化时，那行被引用对象的状态由于被保存也会被恢复
			 2.不能实施串行化的四种情况
				 ①一个类与本地代码有关系
				 ②对象的内部状态依赖JVM，从而在每一次运行时这个状态都有可能不同。如：
					 Thread,InputStream
				 ③串行化可能带来的潜在危险，SecurityManager
				 ④一个类仅有静态方法， 没有内部状态
		 */
	 }
}