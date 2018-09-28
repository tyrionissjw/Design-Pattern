public class ConcreteColleague1 extends Colleague {
	 private Colleague c;
	 private Mediator m;
	 
	 public void action() {
		 System.out.println("ConcreteColleague1 action");
	 }
	 
	 public void setMediator(Mediator m) {	
		 this.m = m;
	 }
	 
	 public Mediator getMediator() {
		 return m;
	 }
}
	 