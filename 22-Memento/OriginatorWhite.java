public class OriginatorWhite {
	 private String state;
	 
	 public MementoWhite createMemento() {
		 return new MementoWhite(state);
	 }
	 
	 public void restoreMemento(MementoWhite m) {
		 this.state = m.getState();
	 }
	 
	 public void setState(String state) {
		 this.state = state;
	 }
	 
	 public String getState() {
		 return state;
	 }
}