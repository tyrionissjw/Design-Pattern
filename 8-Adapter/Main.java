/*适配器模式作用：
   ①把一个类的接口变换成客户端期待的另一种接口，从而使原本因接口不匹配而无法一起工作的两个类能够一起工作
   ②建立一些可重复使用的类，这些类用于关联一些关系不太大的类或者将要引进的类一起工作，这些类没有复杂的接口
   ③JDK中使用该模式：java.io.InputStreamReader(InputStream)    
   2、我们假设你有一个旧系统，现在你需要让它适应新的三方库，但是这个库用的是完全不同的API。旧系统适用的接口是
   完全不同于新库的。当然，你若够勇敢的话，可以改掉旧的代码以适用新的接口。但是对于所有旧系统来说，千万不要这么做
							Request
   Existing System--------------->New Lib(Adaptee)  Don't do this
   可以简单的写一个适配器,好的设计不仅是可以重复使用，还要具有可扩展性。
   							Request					Translated Request
   Existing System--------------->Adapter------------------------->New Lib(Adaptee)  Do like this
   
*/
// 分类：①类适配器②对象适配器
public class Main {	
	 public static void main(String[] args) {
		 /*
     		 类适配器模式。
			 ①Target只能是接口,继承Adaptee			 
			 ②Target中需要实现f()，而源(Adaptee)中有f()方法，又由于适配器(ClassAdapter)是继承自Adaptee，因此无需写成
			 public void f() {
				 super.f();
			 }
			 ③由于适配器是源的子类，因此可以置换掉源已经存在的方法(f())。如：
			 public void f() {
				 System.out.println("适配器置换源的方法");
			 }
			 ④由于源没有business方法而Target中有，因此在Adapter中补充实现，而适配器不是为了补充源不存在的方法而准备的。
		*/		 
		 TargetIterface ti = new ClassAdapter();
		 ti.f();
		 ti.business();
		 System.out.println("***********");
		 /*
		     对象适配器模式。
			 ①Target可以是接口，也可以是抽象类，引用Adaptee
			 ②可以将多个源适配，即可以动态改变源类的多个子类的接口，如line35。
			 ③不易覆盖源中已经存在的方法，若想覆盖则必须置换掉源的方法，必须发先做一个源的子类将源中方法置换掉，通过适配子类达到目的
			 而适配器模式则要对每一个子类做一个适配器，不实际。
		 */
		 Adaptee adt = new Adaptee();
		 Adaptee adt1 = new Adaptee1();
		 Target t = new ObjAdapter(adt);
		 t.f();
		 ((ObjAdapter)t).setSource(adt1);
		 t.f();
		 t.business();
		 
		 
		 /*
			 缺省的适配器模式
			 ①它为一个接口提供一个空实现(DefaultAdaptee相当于源)，DefaultAdaptee子类型-DefaultAdapter相当于Adapter，可以选择实现接口中部分方法
			 ②适用范围：不准备实现一个接口中所有方法
			 ③例子：awt中windowAdapter
			 ④缺省的适配器类(DefaultAdaptee)不应该被实例化
		 */
		 TargetIterface ti1  = new DefaultAdapter();
		 
	 }
}

