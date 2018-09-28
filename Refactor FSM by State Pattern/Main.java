/*
	 1.����״̬��������ʮ����ת����һ���򵥵�����״̬��-FSM
	 2.�������ֱ�����ʽ��
		 ��STD-״̬Ǩ��ͼ
			 �Ĳ�����ɣ�״̬(Բ��)��Ǩ��(����״̬�ļ�ͷ)���¼���/������(��ͷ�ϵı�ע)
		 ��STT-״̬Ǩ�Ʊ�	
			 �Ĳ�����ɣ���ʼ״̬�������¼�����ֹ״̬��Ҫִ�еĶ���
*/
public class Main {
	 public static void main(String[] args) {
		 /*
			 Ƕ��switch/case
			 �ŵ㣺�����ڼ򵥵�FSM������״̬���¼�����һ�����
			 ȱ�㣺���ʺϸ���FSM������״̬�����߼�״̬��ʵ�ֶ����Ĵ���֮��û�кܺõķ���
				 (����ĳ���ʹ��controller������)�����������д��switch/case��
		 */
		 TurnStileController controller = new TurnStileControllerImp();
		 TurnStile ts = new TurnStile(controller);
		 ts.event(ts.COIN);
		 /*
			 ״̬Ǩ�Ʊ�-����һ������״̬Ǩ�Ƶ����ݱ��ñ�һ�������¼���������ͣ�����������¼�ƥ���Ǩ�ƣ�
			 ������Ӧ�Ķ��������ı�״̬
			 �ŵ㣺״̬�����߼�ȫ��������һ����δ��������ʵ����Ⱦ��Ҫ�����µ�Ǩ�ƣ�ֻ����TurnStileSTT�Ĺ��캯��
				 ������һ��addtransition����Ǩ�Ʊ��������ʱ��̬�ı䣬������̬�ı�״̬�����߼����ۿɴ������Ǩ�Ʊ�
				 ÿ��������һ����ͬ��״̬���߼�����Щ����Ը�������������̬ѡ��
			 ȱ�㣺��
			 
		 */
		 TurnStileSTT stt = new TurnStileSTT(controller);
		 stt.event(stt.PASS);
		 /*
			 ״̬ģʽ
			 ���׷�����״̬�����߼��Ͷ���������ʵ��context��ʵ�֡����߼��Ƿֲ���state��������У���ʹ���߿��Զ����仯��
			 ʹ��һ���µ�state���࣬�Ϳ��Դ���һ����ͬ��״̬�߼���������context��Ķ������෴��Ҳ�����ڲ�Ӱ��state����
			 �߼��´���context���������Ļ��滻����ʵ��
		 */
		 TurnStileContext context = new TurnStileContext(controller);
		 context.pass();
	 }
}