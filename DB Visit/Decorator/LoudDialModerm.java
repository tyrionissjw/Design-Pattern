public class LoudDialModerm implements Moderm {
	 private Moderm itsModerm;
	 
	 public LoudDialModerm(Moderm itsModerm) {
		 this.itsModerm = itsModerm;
	 }
	 
	 public void dial() {
		 itsModerm.setVolumn(100);
		 itsModerm.dial();
	 }
	 
	 public void setVolumn(int v) {
		 itsModerm.setVolumn(v);
	 }
}