public class  SingletonLazyMan {
     private static SingletonLazyMan instance;	 
	 
	 private SingletonLazyMan() {
	 }
	 
	 public static SingletonLazyMan getInstance() {
           synchronized (SingletonLazyMan.class) {
		         if (instance == null) {
				      instance = new SingletonLazyMan();
				 }
				 return instance;
		   }
	 }
	 
	 
	  public  synchronized static  SingletonLazyMan getInstance1() {
		         if (instance == null) {
				      instance = new SingletonLazyMan();
				 }
				 return instance;
	 }
}