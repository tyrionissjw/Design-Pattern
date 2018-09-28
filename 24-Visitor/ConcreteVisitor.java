public class ConcreteVisitor  extends VisitorAdater{
	 public void visit(NodeA node) {
		 super.visit(node);
		 System.out.println("after visit NodeA");
	 }
	 
}