import java.io.*;
/*
1、单例模式特点：1.只有一个实例  2.实例由自身创建  3.为其他对象提供该实例
2、单例模式的应用:资源管理器(软件内部或外部)，windows回收站，抽象工厂，具体工厂，具体的建造者
在使用EJB,RMI,JINI等分布式系统中或者在一个JVM但有多个类加载器的情况下(如：J2EE服务器允许多个servlet引擎)避免使用有状态的单例对象
3、对于频繁使用的对象，省略创建对象的花费时间，对于重量级对象来说由于new操作的
次数减少，因而系统内存的使用率降低，减低GC压力，缩短GC停顿时间对于系统关键组
件和被频繁使用的对象使用单例改善

不应用单例模式管理可共享资源的生命周期
即使将单例类中instance赋予null，系统中仍有其他地方引用instance，无法垃圾回收。随后再调用getInstance()方法就创建了另一个实例，致使有两个实例而不成为单例。
一个有状态的单例一般是可变对象，一个没状态的单例一般是不可变对象
不完全单例：有公有的构造函数。优点：客户端灵活选择如何实例化。缺点：选择错误
单例模式使用了简单工厂模式提供自己的实例


Math类是否为单例模式？答：不是。虽然它有私有的构造函数，但是它不满足单例模式的特点3。实际上它的构造私有函数只是为了
满足不可实例化

双重检查本身的目的：由于普通的懒汉式模式的同步化只在单例变量赋值之前有效，赋值后继续同步是瓶颈
因此使用双重检查在同步块外加入if判断。
但由于java对对象的初始化步骤(1.申请一块内存 2.将其地址赋予引用 3.构件对象)
会影响if判断(在第2步后)，因此双重检查在java中不适用。

双重检查在Java version 5.0以上上运行得很好，因为synchronized和volatile特性已经实现了
public class ApplicationCache{
 
   private Map<String, Object> attributeMap;
   // volatile so that JVM out-of-order writes do not happen
   private static volatile ApplicationCache instance;
 
   public static ApplicationCache getInstance(){
      // Checked once
      if(instance == null){
         // Synchronized on Class level lock
         synchronized(ApplicationCache.class){
            // Checked again
            if(instance == null){
               instance == new ApplicationCache();
            }
         }
      }
      return instance;
   }
 
   private ApplicationCache(){
      attributeMap = createCache(); // Initialize the cache
   }
}
让instance变量volatile，这样JVM避免了乱序写操作(out-of-order writes)。在对初始作同步时，对
instance是否是null检查了两次，这样就避免了两个以上的线程创建多过一个cache的实例

4、注意：
①反射(Reflection)API会调用私有的构造器，对于单例模式为了防止创建超过一个实例，可以通过从构造器抛出异常来解决。
②序列化和反序列化可能会创建两个不同的实例，可以通过重写序列化API中的readResolve()方法来解决。

5、枚举实现单例
public enum MaYun {
	himself; //定义一个枚举的元素，就代表MaYun的一个实例
	private String anotherField;
	MaYun() {
	//MaYun诞生要做的事情
	//这个方法也可以去掉。将构造时候需要做的事情放在instance赋值的时候：
	/** himself = MaYun() {
	* //MaYun诞生要做的事情
	* }
	**/
}
public void splitAlipay() {
	System.out.println(“Alipay是我的啦！看你丫Yahoo绿眉绿眼的望着。。。”);
}
}
Call：MaYun.himself.splitAlipay();
*/
/**
 * 使用枚举的单例模式
 *
 * @author yzl
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EnumSingleton{
    private EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    
    private static enum Singleton{
        INSTANCE;
        
        private EnumSingleton singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return singleton;
        }
    }
}
public class Main {   
   /*        懒汉式，饿汉式
       1.均需保证私有构造函数，防止外部直接实例化
       ①对于Eagar单例模式，由于intance变量是static的，因此JVM加载单例类时，单例对象
        就会创建，即任何使用该单例方法的地方(craeteString)就会自动创建单例类，而不管是否
        它能被用到，但如果单例类创建耗时，就造成系统相关函数调用慢
        ②Lazy解决这个问题
        ③Eagar和Lazy，由于前者不需要同步方法，而后者需要。循环测试，它们
        相差2个数量级。
	   2.实例变量instance和getInstance均为static(饿汉式的实例变量instance用final修饰)
   */      

   public static void main(String[] args)  {
      /*         登记式单例
        1.克服 懒汉式，饿汉式不可继承的特点
		2.子类必须是懒汉式(从父类继承的特点)
		3.父类的构造函数至少是protected的，因为子类要继承
		4.子类的构造函数必须是public的，因为在父类的getInstance中使用Class.forName(子类).newInstance()创建子类对象		
   */
        RegSingleton rs = RegSingletonChild.getInstance();
		rs.doBusiness();
		RegSingleton rs1 = RegSingleton.getInstance("RegSingleton");
		rs1.doBusiness();
				
		//Runtime是单例类，每个java程序都只有一个。该例表明如何利用runtime打开一个外部程序
		try {
		   Runtime.getRuntime().exec("notepad.exe");
		} catch(IOException ex) {
		    ex.printStackTrace();
		}
		
		/*
			 1.Monostate模式：通过把所有变量设为static的，来实现单例
			 优势：
			 ①多态性：由于Monostate中实例不是static的并且构造方法也不是私有的，因此弥补普通单例模式不能继承的缺点(子类也是Monostate模式)
			 ②透明性：可通过new XXX()创建对象，弥补普通单例模式由于使用getInstance而使客户知道这是一个单例模式的不透明性。
			 缺点：
			 ①不易通过子类的方式将常规类转换为Monostate模式
			 ②效率问题，通通过new XXX()在Monostate中仍然是重复创建对象，并没有像上面的单例只创建一个对象，会导致创建和销毁的开销
			 ③内存占用，即使从未使用Monstate，它的变量也要占用内存			 
			 ⑤数据永远不会丢失即使实例不存在
		*/
		 Monostate singleton = new Monostate();
		 
		 /*
		   Initialization on Demand Holder(线程安全+延迟加载+static单例)
            当SingeltonIodh被加载时，其内部类不会被初始化，故可以确保当SingeltonIodh类载入JVM
            时，不会初始化单例类，而当调用getInstance才会加载SingeltonIodhHodler，从而初始化
            instance。由于实例的建立是在类加载时完成，线程安全，因此省略了synchronized关键字。
		 */
		 SingletonIodh instance = SingletonIodh.getInstance();
   }
}