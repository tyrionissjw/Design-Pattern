import java.util.Observable;
public class MyObservable extends Observable {
	private String inState;
	
	public MyObservable(String inState) {
		this.inState = inState;
	}
		
	
	public void changeInstate(String newState) {
		if (!newState.equals(inState)) {
			this.inState = newState;
			//setChanged()��notifyObservers()����Ч
			setChanged();
		}
		notifyObservers();
		System.out.println("Finished");
	}	
	
}
