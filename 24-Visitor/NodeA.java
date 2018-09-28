public class NodeA implements Node {
	 public void accept(Visitor v) {
		 v.visit(this);
	 }
	 
	 public void fa() {
		 System.out.println("This is NodeA");
	 }
}