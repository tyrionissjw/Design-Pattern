import java.util.Observable;
import java.util.Observer;
public class Main  {
    //δ����ObserverQueue֮ǰ
    public static void test1 () {
	   	MyObservable mo = new MyObservable("A");
		Observer1 o1 = new Observer1();
		o1.attachObservable(mo);
		Observer2 o2 = new Observer2();
        o2.attachObservable(mo);
		Observer3 o3 = new Observer3();
		o3.attachObservable(mo);
		mo.changeInstate("B");		
	}
	
	/**
        ����ObserverQueue��ʹMyObservable��notify��������ȴ�3���۲��ߵ�update����������
        ��������3��Observer��Ȼ����ÿ��˯��3���������У�һ����Ҫ9�롣
    **/
	public static void test2 () {			    
		ObserverQueue oq = new ObserverQueue();
		Thread threadPacker  = new Thread(oq);			        
		Observer1 o1 = new Observer1();
		o1.attachObservable(oq);
		Observer2 o2 = new Observer2();
        o2.attachObservable(oq);
		Observer3 o3 = new Observer3();
		o3.attachObservable(oq);
		//ObserverQueueҪ�ڱ�����3���۲��߼ӳ�����������ܵ���,��������һֱqueue.size=0����������get()������
		//ʹ��wait����ObserverQueue��getʱ,��Ҫ��line:31�Ĵ�����ǰ��threadPacker.start()ǰ������һֱ������get()��
		//ʹ��sleep����ObserverQueue��getʱ,û������
		MyObservable mo = new MyObservable("A");
		threadPacker.start();										
		// MyObservable mo = new MyObservable("A");
		oq.attachObservable(mo);		
		mo.changeInstate("B");
	}
	
	public static void main(String[] args) {
	        //test1();
			test2();
	}		
	
	
}
