public class SingletonEagerMan {
     private final static SingletonEagerMan instance = new SingletonEagerMan();
	 
	 private SingletonEagerMan() {
	 }
	 
	 public static SingletonEagerMan getInstance() { 
	       return instance;
	 }
}