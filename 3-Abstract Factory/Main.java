public class Main {
   // ���󹤳�����"�����Ʒ��ɫ�Ĺ���"
   // ���빤���������������:ǰ����Զ����Ʒ�ȼ��ṹ������ֻ���һ����Ʒ�ȼ��ṹ   
   // ���󹤳�������䱸��̬���������ؾ��幤��ʵ��
   // ���幤��������䱸һ����̬���������ؾ��幤�����Լ�
   /*
    java.awt���У�һ��java�����������ϵͳ�޹صģ���һ������ײ����ϵͳ�йص�Peer����
	java.awt.ToolKit���������Ϊ��ͬ�Ĳ���ϵͳ�ṩPeer���������Ĺ�����(�൱�ڳ��󹤳�)
	��java������ͨ��Tookit����Peer����ͨ��(����ģʽ)
   */
   public static void main(String[] args) {
        //IllegalArgument
        AbstractFactory.createFactory(4);
        AbstractFactory a1 = AbstractFactory.createFactory(1);
		AbstractFactory b1 = AbstractFactory.createFactory(2);
		AbstractFactory c1 = AbstractFactory.createFactory(3);				
		a1.createProductA();
		a1.createProductB();
		b1.createProductA();
		b1.createProductB();
		c1.createProductA();
		c1.createProductB();
		
		AbstractFactory a2 = FactoryA.newInstance();
		AbstractFactory b2 = FactoryB.newInstance();
		AbstractFactory c2 = FactoryC.newInstance();
		
		
		
		
   }
}