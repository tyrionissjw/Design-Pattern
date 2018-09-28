/*
  1.config作为联系chain和Handler的纽带，config将handler作为变量，chain将config作为变量
  2.config需要构造pattern，在chain中通过是否符合config的pattern来决定是否执行该config对应的handler
  3.config.construct()使用建造模式构造config中的Pattern
  4.handler中的execute使用chain作为参数并执行chain的executeHandler方法执行下一个handler，来代替传统的handler中执行下一个handler时
     使用的successer   
	
*/
public class Main {
     public static void main(String[] args) {
	     HandlerConfig[] config = new HandlerConfig[2];
		 config[0] = new HandlerConfig();
		 config[0].setHandler(new ConcreteHandler());
		 config[0].setHandlerName("0");
		 config[0].setRegex("[0-9]*");
		 config[0].construct();
		 config[1] = new HandlerConfig();
		 config[1].setHandler(new ConcreteHandler1());
		 config[1].setHandlerName("1");
		 config[1].setRegex("[a-zA-Z]*");
		 config[1].construct();
		 
         HandlerChain chain = new HandlerChain("A",config);
		 chain.executeHandler();
	 }
	 
	 
}