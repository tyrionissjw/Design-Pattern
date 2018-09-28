public class ConcreteCommand1 implements Command {
	 private Receiver recv;
	 
	 public ConcreteCommand1(Receiver recv) {
		 this.recv = recv;
	 }
	 
	 public void execute() {
		 recv.action1();
	 }
}