public class Main {
   //����Ʒ�ṹ����ʱ��ʹ��һ������������ͬ��Ʒ���ŵ㣺�����ṹ���䣬ֻ��һ�������ࡣȱ�㣺���������仯
   //���ڼ򵥹���ʹ�þ�̬�������޷��̳С���˹�����ɫ�޷��γɵȼ��ṹ��
   public static void main(String[] args) {
        Product p = CommonFactory.factory();
		p.business();
		ProductWithFactory p1 = ProductWithFactory.factory();
		p1.business();
		Product p2 = ConcreateProduct3.factory();
		p2.business();
   }
}