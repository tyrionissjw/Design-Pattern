public class ConcreteHandler implements Handler {
     public void execute(HandlerChain chain) {	     
	     preBusiness();
	     chain.executeHandler();
		 afterBusiness();
	 }
	 
	 public void preBusiness() {
	     System.out.println("pre");
	 }
	 
	 public void afterBusiness() {
	     System.out.println("after");
	 }
}