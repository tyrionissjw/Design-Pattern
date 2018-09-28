import java.util.Observer;
import java.util.Observable;
public class Observer2 implements Observer {		
	public void update (Observable o, Object arg) {
		//��ʱ�߼�
		 try {
		       Thread.sleep(3000);
		   } catch (InterruptedException ex) {}
	      System.out.println("Observer2: "+arg) ;		

	}
	
	public void attachObservable(Observable watched) {
		watched.addObserver(this);
	}
}