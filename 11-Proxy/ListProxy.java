import java.lang.reflect.*;
import java.util.*;
public class ListProxy implements InvocationHandler {	
	 private Object proxyObj;
	 
	 public ListProxy(Object proxyObj) {
		 this.proxyObj = proxyObj;		 
	 }
	 
	 public static Object factory(Object subject) {
	     Class cls = subject.getClass();
		 return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new ListProxy(subject));		 		
	 }
	 
	 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 System.out.println("before calling");
		 if (args != null) {
			 for (int i = 0 ; i<args.length ; i++) 
				 System.out.println(args[i]);
		 }		 
		 Object result = method.invoke(proxyObj, args);
		 System.out.println("after calling");
		 return result;
	 }
	 
	 public static void main(String[] argfs) {
		 List v = null;
		 v = (List)factory(new ArrayList(10));
		 v.add("1");
		 v.add("2");
	 }
}