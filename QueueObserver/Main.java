import java.util.Observable;
import java.util.Observer;
public class Main  {
    //未加入ObserverQueue之前
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
        加入ObserverQueue，使MyObservable的notify方法无需等待3个观察者的update方法结束，
        但是其他3个Observer仍然按照每个睡眠3秒依次运行，一共需要9秒。
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
		//ObserverQueue要在被其他3个观察者加成主体对象后才能调用,否则由于一直queue.size=0程序阻塞在get()方法中
		//使用wait阻塞ObserverQueue的get时,需要将line:31的代码提前至threadPacker.start()前，否则一直阻塞在get()中
		//使用sleep阻塞ObserverQueue的get时,没有限制
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
