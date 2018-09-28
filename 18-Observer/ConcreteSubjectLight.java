public class ConcreteSubjectLight extends SubjectHeavy {
	 private String inState;
	 
	 public void change(String newState) {
		 this.inState = newState;
		 this.notifyObservers();
	 }
}