import java.util.*;
public class RegSingleton {
   private static HashMap registers = new HashMap();          
  /*
   static 
   {
         RegSingleton rs = new RegSingleton();
		 registers.put(rs.getClass().getName(), rs);
   }
*/
   
   protected RegSingleton() {
   }
      
   public static RegSingleton getInstance(String className) {
         if (className == null)  {
               throw new IllegalArgumentException("参数不能为Null");
		 } 
		 if (registers.get(className) == null) {
		    try {
			    registers.put(className, Class.forName(className).newInstance());
			} catch(Exception ex) {
			     throw new RuntimeException("无法实例化该类 "+ex);
			} 
		 } 
		 return (RegSingleton)registers.get(className);
   }
   
   	 public void doBusiness() {
	       System.out.println("this is RegSingleton!");
	 }
}