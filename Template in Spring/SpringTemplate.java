public class SpringTemplate {
	/*
		 ģ�巽��
	*/	
	 public Object execute(SpringCallBack callBackArg, String arg1, int arg2) {
		 System.out.println("arg1: "+arg1);
		 Object result  = callBackArg.doPrimary(arg1);
		 System.out.println("result: "+result);
		 System.out.println("arg2: "+arg2);
		 return result;
	 }
	 	 
	 
     /*
		 ��ҵ����1
	 */
	 public Object load1(String arg1, int arg2) {
		 System.out.println("pre business");
		 return execute(new SpringCallBack() {
			 public Object doPrimary(Object arg1) {
				 System.out.println("�Լ�����ҵ�߼�");
				 return arg1;
			 }
		 },arg1, arg2) ;		 
	 }
}