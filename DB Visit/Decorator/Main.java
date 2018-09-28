/*
	 ��һ�ֲ��ı����νṹΪ�����ӹ��ܵķ�����
*/
public class Main {
	 public static void main(String[] args) {
		 /*
		 1.����ʹ�����ַ�ʽ����װ�Ρ�װ��һ��ҵ����󲢸���read��write����������װ��
		 һ��֪����ζ�д��������ݿ���󲢸�����ҵ����򣬺�һ�ַ�����ʹ������������ݿ�
		 ʱ�Ǻ����õġ�
         */
		 Product p = new ConcreteProduct();
		 Product decorator = new DBDecorator(p);
		 decorator.doBusiness();
		 
		 /*
			 1.����Moderm���Σ��������������:
				 ������һ���кܶ�ʹ���ߵ�Ӧ�ó���ÿһ��ʹ���߶���ͨ�������Ҫ��ͨ���ĳ������õ��ƽ����������һ̨�������
				 ������Щ�û�ϣ����������������Щ�򲻡�
			 �Դˣ�������������ƣ�
				 ��ͨ���ڴ�����ÿһ���Ե��ƽ��������(Moderm��dial����)�ĵط�ѯ��ʹ�����Ƿ�ϣ����������������				 	
					 ...
					 Moderm m = user.getModerm();
					 if (user.wantsLoudDial())
						 m.setVolume(11);
					 m.dial(...);
					 ...
				     ȱ�㣺�����ظ�������Ӧ�ó�����
				 ����ÿ��Moderm������������һ���Ƿ������ı�־��dial�����и��ݱ�־ȥ��������
					 ...
					 private boolean wantsLoudDial = false;
					 public void dial() {
						 ...
						 if (wantsLoudDial)
						  setVolume(11);
						 else
						   setVolume(0);
					 }
					 ..
					 ȱ�㣺Moderm�������б��붼����δ��룬Moderm������ı�д�߱����ס��δ��롣
				 �۶���ʵ�֢ڵ�ȱ��(��������Ա����)��ʹ��Template�ع�Morderm�����һ���ӿڱ�Ϊһ�������ࡣ
				  ��������wantsLoudDialʵ������������������dial�������ȼ����ñ�������ȥ����������dial����dialForReal
				  ...
				  public void dial() {
					 ...
					 if (wantsLoudDial)
						 setVolume(11);
					 else 
						 setVolume(0);
					 dialForReal();	 
				  }
				  ȱ�㣺ʹ���ߵ�ͻȻ�뷨��Ӧ��Ӱ��Moderm�ṹ��������Ϊ����SRPԭ�򣬴������ŵ�����͵��ƽ���������ڹ���û��ϵ������
				  ����Ӧ�ó�Ϊ���ƽ������һ���֡�				  				  
		 */
		 /*
			 Decoratorģʽ����������Ľ��.
		 */	
		 Moderm m = new HayezModerm();
		 Moderm decoratorModerm = new LoudDialModerm(m);
		 decoratorModerm.dial();
	 }
}