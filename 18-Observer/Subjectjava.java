import java.util.Observable;
public class Subjectjava extends Observable {
	 private String data = "";
	 
	 public void changeData(String newData) {
		 if (!data.equals(newData)) {
			 data = newData;
			 setChanged();
		 }
		 notifyObservers();
	 }
}