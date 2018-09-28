public class ConcreteCommand implements Command {
	 private Receiver recv;
	 
	 public ConcreteCommand(Receiver recv) {
		 this.recv = recv;
	 }
	 
	 public void execute() {
		 recv.action();
	 }
}