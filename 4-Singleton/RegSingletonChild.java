public class RegSingletonChild extends RegSingleton {
     public RegSingletonChild() {
	 }
	 
	 public static RegSingleton getInstance() {
	     return (RegSingleton)RegSingleton.getInstance(RegSingletonChild.class.getName());
	 }
	 
	 public void doBusiness() {
	       System.out.println("this is RegSingletonChild!");
	 }
}