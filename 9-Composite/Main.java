/*
	 �����ã���������֯�����ṹ��ȥ�������������������벿�ֹ�ϵ����ʹ�ͻ��˽�����Ԫ���븴��Ԫ��ͬ�ȿ���
	 �ڷ��ࣺ͸��ʽ�Ͱ�ȫʽ
	 ����compoent�м���set��get���������Դ��游����
	 ����Composite�л����ӹ�����ͨ�����ز����޸���ͼ��
	 ��͸��ʽ��Leaf��add��remove�������Կ�ʵ�ֻ����׳�����֧���쳣
	 �޼�������A����B��һ��һ�����ģ���ѹ�����Ϊһ�Զࡣ���蹹��һ�������б����ڴ�������һ�Զ��ϵ
	 ��ʹ��"һ��һ"(Composite������Ԫ�غ͸���Ԫ��ͬ�ȿ���)���������б����ͱ����Ĵ�����������г���һ�Σ�
	 �������ڿͻ����ظ����֡����ָ����ǰ�᣺ֻ����Щ��һ�·�ʽ�Դ��б���ÿһ��Ԫ�ص�������ʺ�
	 ��JDK��ʹ��ģʽ�ĵط���java.util.Map.putAll(Map m);  
	 
*/
public class Main {
	 public static void main(String[] args) {
		 SafetyComponent cLeaf = new SafetyLeaf();
		 cLeaf.business();
		 SafetyComponent l1 = new SafetyLeaf();
		 SafetyComponent l2 = new SafetyLeaf();
		 SafetyComposite cc = new SafetyComposite();
		 cc.add(l1);
		 cc.add(l2);		 
		 cc.business();
		 System.out.println(cc.getBufferedChildren());
	 }	
}