/*������ģʽ���ã�
   �ٰ�һ����Ľӿڱ任�ɿͻ����ڴ�����һ�ֽӿڣ��Ӷ�ʹԭ����ӿڲ�ƥ����޷�һ�������������ܹ�һ����
   �ڽ���һЩ���ظ�ʹ�õ��࣬��Щ�����ڹ���һЩ��ϵ��̫�������߽�Ҫ��������һ��������Щ��û�и��ӵĽӿ�
   ��JDK��ʹ�ø�ģʽ��java.io.InputStreamReader(InputStream)    
   2�����Ǽ�������һ����ϵͳ����������Ҫ������Ӧ�µ������⣬����������õ�����ȫ��ͬ��API����ϵͳ���õĽӿ���
   ��ȫ��ͬ���¿�ġ���Ȼ���������¸ҵĻ������Ըĵ��ɵĴ����������µĽӿڡ����Ƕ������о�ϵͳ��˵��ǧ��Ҫ��ô��
							Request
   Existing System--------------->New Lib(Adaptee)  Don't do this
   ���Լ򵥵�дһ��������,�õ���Ʋ����ǿ����ظ�ʹ�ã���Ҫ���п���չ�ԡ�
   							Request					Translated Request
   Existing System--------------->Adapter------------------------->New Lib(Adaptee)  Do like this
   
*/
// ���ࣺ�����������ڶ���������
public class Main {	
	 public static void main(String[] args) {
		 /*
     		 ��������ģʽ��
			 ��Targetֻ���ǽӿ�,�̳�Adaptee			 
			 ��Target����Ҫʵ��f()����Դ(Adaptee)����f()������������������(ClassAdapter)�Ǽ̳���Adaptee���������д��
			 public void f() {
				 super.f();
			 }
			 ��������������Դ�����࣬��˿����û���Դ�Ѿ����ڵķ���(f())���磺
			 public void f() {
				 System.out.println("�������û�Դ�ķ���");
			 }
			 ������Դû��business������Target���У������Adapter�в���ʵ�֣�������������Ϊ�˲���Դ�����ڵķ�����׼���ġ�
		*/		 
		 TargetIterface ti = new ClassAdapter();
		 ti.f();
		 ti.business();
		 System.out.println("***********");
		 /*
		     ����������ģʽ��
			 ��Target�����ǽӿڣ�Ҳ�����ǳ����࣬����Adaptee
			 �ڿ��Խ����Դ���䣬�����Զ�̬�ı�Դ��Ķ������Ľӿڣ���line35��
			 �۲��׸���Դ���Ѿ����ڵķ��������븲��������û���Դ�ķ��������뷢����һ��Դ�����ཫԴ�з����û�����ͨ����������ﵽĿ��
			 ��������ģʽ��Ҫ��ÿһ��������һ������������ʵ�ʡ�
		 */
		 Adaptee adt = new Adaptee();
		 Adaptee adt1 = new Adaptee1();
		 Target t = new ObjAdapter(adt);
		 t.f();
		 ((ObjAdapter)t).setSource(adt1);
		 t.f();
		 t.business();
		 
		 
		 /*
			 ȱʡ��������ģʽ
			 ����Ϊһ���ӿ��ṩһ����ʵ��(DefaultAdaptee�൱��Դ)��DefaultAdaptee������-DefaultAdapter�൱��Adapter������ѡ��ʵ�ֽӿ��в��ַ���
			 �����÷�Χ����׼��ʵ��һ���ӿ������з���
			 �����ӣ�awt��windowAdapter
			 ��ȱʡ����������(DefaultAdaptee)��Ӧ�ñ�ʵ����
		 */
		 TargetIterface ti1  = new DefaultAdapter();
		 
	 }
}

