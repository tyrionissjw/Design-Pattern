/*
	 1.优点：简单有效
	 2.缺点：使对象(product和Assembly)与DataBaseFacade耦合。
		 对象要知道Facade因为它们要调用facade的read和write函数，Facade要知道对象因为它必须使用对象的访问方法去实现read和write
     3.应用场合:耦合稍大的系统中不适合，较小和刚开始的系统中使用。当后来决定改变到一个耦合较小的系统时，facade也易于重构
*/
public class Main {
	 public static void main(String[] argfs) {
	 }
}