public class ConcreteFlyWeight implements FlyWeight {
	 private String insideState;
	 
	 public ConcreteFlyWeight(String insideState) {
		 this.insideState = insideState;
	 }
	 
	 public void f(String outsideState) {
		 if (outsideState.equals("1")) 
			 System.out.println("one "+insideState);
	     else 
			 System.out.println("other "+insideState);
	 }
}