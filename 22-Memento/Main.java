/*
	 1.���ã���һ��������������һ�������ڲ�״̬�Ŀ��ա��ڲ��ƻ���װ�������(��װ��Ϊ������Σ��ɶ�����д�����ɶ�����д)��
		 ��һ�������״̬��׽�����ⲿ�����ں��ʵ�ʱ����������ԭ������״̬��
	 2.����¼���Ա��������ݲ���������֮����κζ����ȡ�����ɶ�����д��
	 3.�ŵ㣺�����˵�״̬�ı�ʱ���������״̬��Ч����ʱ��Ϳ���ʹ�ñ���¼��ɫ�ָ�
	 4.ȱ�㣺��Դ���Ĵ�
	 
   	 ��HttpSessionʹ�ñ���¼ģʽ
	 �����ˣ���վϵͳ������¼��Object In Session�������ˣ�HttpSession
	 ��Cookieʹ�ñ���¼ģʽ
	 �����ˣ���վϵͳ������¼��Cookie�������ˣ������
	 ��Q:��������վsite1��site2����һ���û�����site1ʱ��ʹ��session���١��û���site1����site2����һ��ʱ���ֻص�site1.��ʱ�û���
		 site1�ľ�session�Ѿ����������������ܱ���סsession�����û��ص�site1������ʹ�ã�
		 A:��һ�ֽ����������session��timeout��Ϊ-1��ȱ�����û����������logout�˳�site1����ֱ�ӹر��������session����Զ�ڷ���
		 ���˴��ڣ��˷���Դ��
		 B:ʹ�ñ���¼ģʽ����HttpSessionBindingListener�ӿ��ܵ�sessionʧЧ���¼��󣬽�session���󴢴������ݿ���ļ��С����û��ٴ�
		 �ص�site1ʱ�������ؽ�session
     ��Q:���ⲿ�� outer��ʵ��û�����ã������ڲ���Inner��������ʱ���ⲿ���ʵ���᲻�ᱻ�������գ�
		 A:���ᡣ��Ϊ�ڲ�����outer.thisָ���ⲿ��ʵ��������
*/
public class Main {
	 public static void main(String[] args) {
		 /*
			 ����ʵ�֣���Memento��Originator��CareTaker���ǿ�ӿڣ�����¼�����ڲ�����״̬�����ж��󶼹���
			 ����ʵ���ƻ���װ����ͨ������Ա���ɣ�����ʵ�������������
		 */
		 // �����˽�ɫ������һ�����е�ǰ�ڲ��������ڲ�״̬�ı���¼����ʹ�ñ���¼���󴢴����ڲ�״̬
		 OriginatorWhite originator = new OriginatorWhite();
		 // �����˽�ɫ�����𱣴汸��¼���󣬲����������
		 CareTakerWhite ct = new CareTakerWhite();
		 originator.setState("on");
		 MementoWhite memento = originator.createMemento();
		 ct.saveMemento(memento);
		 originator.setState("off");
		 memento = ct.retrieveMemento();
		 originator.restoreMemento(memento);
		 System.out.println(originator.getState());
		 
		 /*
			 �����+����ʵ�֣�
				 1.�����ʵ��ԭ��ʹ��˫�ؽӿ�(MementorNarrow��MementorBlack)���ҽ�MementorBlack��ΪOriginatorBlack���ڲ��࣬
					 ��֤OriginatorBlack���Կ���Mementor���нӿڣ���������(��ͬһ����)������(����뿴������ͨ��OriginatorBlack,��Ϊ���ڲ���)����Ҫ
					 ���ڲ���ķ��������η�������private��֤ͬһ�����µ������࿴����
		 */
		 System.out.println("��������ģʽ");
		 OriginatorBlack ob1 = new OriginatorBlack();
		 CareTakerBlack ct1 = new CareTakerBlack(ob1);
		 ob1.addStates("A");
		 ob1.addStates("B");
		 ct1.createMemento();
		 ob1.addStates("1");
		 ct1.createMemento();
		 ob1.addStates("2");
		 ct1.createMemento();
		 ct1.restoreMementor(0);
		 ob1.print();
		 /*
			 ������ʷģʽ
			 �ŵ㣺��
			 ȱ�㣺���ϵͳ���ж�������˽�ɫ���������Ǽ��θ����˽�ɫ����˾ͻ��ж�������˽�ɫ�����ظ�����
				 �������ܴﵽ���빲���Ŀ�ģ����Ҳ������ø����˵Ķ�̬����Դ�����״̬���ǵ���״̬���и�����
				 ����ı�д��
		 */
		 System.out.println("������ʷģʽ");
		 OriginatorBlack ob2 = new OriginatorBlack();
		 ob2.addStates("A");
		 ob2.addStates("B");
		 MementorNarrow  mementor1 = ob2.createMemento();
		 ob2.addStates("1");
		 MementorNarrow  mementor2 = ob2.createMemento();
		 ob2.addStates("2");
		 MementorNarrow  mementor3 = ob2.createMemento();		 
		 ob2.restoreMementor(mementor1);
		 ob2.print();

		 
	 }
}