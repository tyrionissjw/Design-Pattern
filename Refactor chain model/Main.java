/*
  1.config��Ϊ��ϵchain��Handler��Ŧ����config��handler��Ϊ������chain��config��Ϊ����
  2.config��Ҫ����pattern����chain��ͨ���Ƿ����config��pattern�������Ƿ�ִ�и�config��Ӧ��handler
  3.config.construct()ʹ�ý���ģʽ����config�е�Pattern
  4.handler�е�executeʹ��chain��Ϊ������ִ��chain��executeHandler����ִ����һ��handler�������洫ͳ��handler��ִ����һ��handlerʱ
     ʹ�õ�successer   
	
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