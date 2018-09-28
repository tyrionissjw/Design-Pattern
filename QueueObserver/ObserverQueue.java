import java.util.Observable;
import java.util.Observer;
import java.util.LinkedList;
import java.util.List;
/*
  继承Observable相对于3个Observer,实现Observer相对于MyObservable
*/
public class ObserverQueue  extends Observable implements Observer, Runnable {
         //queue用于存放消息
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
		     //TODO:更好的阻塞方法--使用wait
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