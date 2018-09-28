public class SpringTemplate {
	/*
		 模板方法
	*/	
	 public Object execute(SpringCallBack callBackArg, String arg1, int arg2) {
		 System.out.println("arg1: "+arg1);
		 Object result  = callBackArg.doPrimary(arg1);
		 System.out.println("result: "+result);
		 System.out.println("arg2: "+arg2);
		 return result;
	 }
	 	 
	 
     /*
		 商业方法1
	 */
	 public Object load1(String arg1, int arg2) {
		 System.out.println("pre business");
		 return execute(new SpringCallBack() {
			 public Object doPrimary(Object arg1) {
				 System.out.println("自己的商业逻辑");
				 return arg1;
			 }
		 },arg1, arg2) ;		 
	 }
}