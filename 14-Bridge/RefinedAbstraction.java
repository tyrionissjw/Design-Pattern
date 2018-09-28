public class RefinedAbstraction extends Abstraction {		 
	 public RefinedAbstraction(String arg) {
		 if (arg.equals("1"))
			 this.impl = new ConcreteImpl();
		 else 
			 this.impl = new ConcreteImpl1();
	 }
	 
	 public void refinedf() {
		 System.out.println("This is a refinedf");
	 }
	 
	 
}