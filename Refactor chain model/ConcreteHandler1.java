public class ConcreteHandler1 implements Handler {
     public void execute(HandlerChain chain) {	     
	     preBusiness();
	     chain.executeHandler();
		 afterBusiness();
	 }
	 
	 public void preBusiness() {
	     System.out.println("pre1");
	 }
	 
	 public void afterBusiness() {
	     System.out.println("after1");
	 }
}