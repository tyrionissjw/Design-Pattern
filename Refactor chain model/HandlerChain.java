public class HandlerChain {
     private int firstElement = -1;
     private HandlerConfig[] configs;	 
	 private String regex;
	 
	 public HandlerChain(String regex) {
	     this.regex = regex;
	 }
	 
	 public HandlerChain(String regex, HandlerConfig[] configs) {
	     this.regex = regex;
		 this.configs = configs;
	 }
	 
     public void executeHandler() {
	     if (configs == null) {
		     NoHandlerBusiness();
			 return;
		 } 
		 firstElement++;
		 if (firstElement < configs.length) {		     
		     if (configs[firstElement].getPattern().matcher(regex).matches()) {
			     configs[firstElement].getHandler().execute(this);
			 } else {
			     this.executeHandler();
			 }
		 }
	 }
	 
	 public void setConfigs(HandlerConfig[] configs) {
	     this.configs = configs;
	 }
	 
	 public void setRegex(String regex) {
	     this.regex = regex;
	 }
	 
	 public void NoHandlerBusiness() {
	     System.out.println("no handler");
	 }
	 
}