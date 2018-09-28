public class ConcreteMediator implements Mediator {
	 private Colleague c1;
	 private Colleague c2;
	 
	 public void colleagueChanged(Colleague c) {
		 c1.action();
		 c2.action();
		 c.action();
	 }
	 
	 public void createColleague() {
		 c1 = new ConcreteColleague1();
		 c2 = new ConcreteColleague2();
	 }
	 
	 public Colleague getC1() {	
		 return c1;
	 }
	 
	 public Colleague getC2() {
		 return c2;
	 }
}