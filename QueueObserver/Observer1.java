import java.util.Observer;
import java.util.Observable;
public class Observer1 implements Observer {		
	public void update (Observable o, Object arg) {
		//ºÄÊ±Âß¼­
		try {
		       Thread.sleep(3000);
		 } catch (InterruptedException ex) {}
	    System.out.println("Observer1: "+arg) ;		

	}
	
	public void attachObservable(Observable watched) {
		watched.addObserver(this);
	}
}