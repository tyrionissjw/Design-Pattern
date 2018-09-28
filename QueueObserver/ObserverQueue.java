import java.util.Observable;
import java.util.Observer;
import java.util.LinkedList;
import java.util.List;
/*
  �̳�Observable�����3��Observer,ʵ��Observer�����MyObservable
*/
public class ObserverQueue  extends Observable implements Observer, Runnable {
         //queue���ڴ����Ϣ
         private LinkedList queue = new LinkedList();
         public void run() {
			while(true) {
                 Object o = get();
				 setChanged();
				 notifyObservers(o);
			}
		 }

		public void attachObservable(Observable watched) {
			watched.addObserver(this);			
     	 }

		 public  void update(Observable o, Object arg) {		     
			queue.add(arg);
		 }

		 public synchronized Object get() {
		     //TODO:���õ���������--ʹ��wait
		     try {
		      while (queue.size() == 0)   
			   // Thread.sleep(1);
				 this.wait(); 				
			 } catch (InterruptedException ex) {
			     ex.printStackTrace();
			 }			 
			 return queue.removeFirst();
		 }




}