public class Main {
   // ����������ȼ򵥹����ĺô��������µĲ�Ʒ�����޸ľ��幤���ֻ࣬������һ�������ࡣ
   // �����ڳ��󹤳��м��벻ͬ�Ĺ������������Դ�����ͬ��ʽ����ͬ��Ʒ��
   /*
     COM����еĹ���������
	    1.�û�����Com�⺯��CoCreateInstance,����CoGetClassObjectʵ��
		2.CoCreateInstance��Register��Ѱ�������Component,�ҵ��Ļ���������DLL
		3.CoGetClassObject����DllGetClassObject������ʵ����CFactory(���幤����)
		4.DllGetClassObject���򹤳���CFactory��ѯ��ӿ�IClassFactory(���󹤳�)�������ظ�CoCreateInstance
		5.CoCreateInstance����IClassFactory��CreateInstance����������Ҫ��Component
   */
   public static void main(String[] args) {
       TopFactory tf = new IFactory();
	   Product p1 = tf.createProduct1();
	   Product p2 = tf.createProduct2();
	   
	   MiddleFactory mf = new IMiddleFactory();
	   Product middlep1 =  mf.createProduct1();
	   Product middlep2  = mf.createProduct2();
       MiddleProduct middlep3 = mf.createMiddleProduct();	   	   
   }
}