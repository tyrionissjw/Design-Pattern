public class Invoker {
	 private Command cmd ;	 
	 private Command cmd1;
	 
	 public Invoker(Command cmd, Command cmd1) {
		 this.cmd = cmd;
		 this.cmd1 = cmd1;
	 }
	 
	 public void action() {
		 cmd.execute();
	 }
	 
	 public void action1() {
		 cmd1.execute();
	 }
}