public class CareTakerWhite {
	 private MementoWhite memento;
	 
	 public void saveMemento(MementoWhite memento) {
		 this.memento = memento;
	 }
	 
	 public MementoWhite retrieveMemento() {
		 return memento;
	 }
}