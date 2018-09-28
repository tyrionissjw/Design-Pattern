public class NodeB implements Node {
	 public void accept(Visitor v) {
		 v.visit(this);
	 }
	 
	 public void fb() {
		 System.out.println("This is NodeB");
	 }
}
