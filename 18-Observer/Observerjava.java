import java.util.Observer;
import java.util.Observable;
public class Observerjava implements Observer {	 	 
	 public Observerjava(Subjectjava watched) {
		 watched.addObserver(this);
	 }
	 
	 public void update(Observable o, Object arg) {
		 System.out.println("Observerjava update");
	 }
}