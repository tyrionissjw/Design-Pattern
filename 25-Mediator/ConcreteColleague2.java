public class ConcreteColleague2 extends Colleague {
	 private Colleague c;
	 private Mediator m;
	 
	 public void action() {
		 System.out.println("ConcreteColleague2 action");
	 }
	 
	 public void setMediator(Mediator m) {	
		 this.m = m;
	 }
	 
	 public Mediator getMediator() {
		 return m;
	 }
}
	 