public abstract class VisitorAdater implements Visitor {
	 public void visit(NodeA node) {
		 node.fa();
	 }
	 
	 public void visit(NodeB node) {
		 node.fb();
	 }
}