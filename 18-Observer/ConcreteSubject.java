import java.util.*;
public class ConcreteSubject implements Subject {
	 private List<Observer> observers = new LinkedList<Observer>();

	 public void notifyObservers() {		 
		 for ( Iterator it = observers.iterator() ; it.hasNext(); ) {
			 Observer o = (Observer)it.next();
			 o.update();
		 }
	 }
	 
	 public boolean attach(Observer o) {
		 /*
			ȷ���� collection ����ָ����Ԫ�أ���ѡ��������
			����� collection ���ڵ��ö��������ģ��򷵻� true��������� collection ���������ظ�Ԫ�أ������Ѿ�������ָ����Ԫ�أ��򷵻� false��)
			��� collection ����ĳЩԭ���Ѿ�������Ԫ�ص�ԭ����⣩�ܾ�����ض���Ԫ�أ���ô������ �׳�һ���쳣�������Ƿ��� false����
			��ȷ�����ڴ˵��÷��غ�collection ���ǰ���ָ����Ԫ�ء� 
		 */
		 return observers.add(o);
	 }
	 
	 public boolean delete(Observer o) {	 
	     /*
			 �Ӵ��б����Ƴ���һ�γ��ֵ�ָ��Ԫ�أ�������ڣ�����ѡ��������
			 ����б�����Ԫ�أ��򲻸����б���ȷ�еؽ����Ƴ����� (o==null ? get(i)==null : o.equals(get(i))) ��������� i ��Ԫ�أ��������������Ԫ�أ���
			 ������б��Ѱ���ָ��Ԫ�أ����ߴ��б����ڵ��ö��������ģ����򷵻� true�� 
		 */
		 return observers.remove(o);
	 }
	 
	 public List getObservers() {
		 return Collections.unmodifiableList(observers);
	 }
}