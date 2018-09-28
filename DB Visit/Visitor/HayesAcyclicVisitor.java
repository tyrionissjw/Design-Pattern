public interface HayesAcyclicVisitor {
	 public void visit(AHayezModermNode node);
}

class AHayezModermNode implements AModermVistor {
	 public void dial() {
		 System.out.println("AHayezModermNode dial");
	 }
	 
	 public void send() {
		 System.out.println("AHayezModermNode send");
	 }
	 
	 public void accept(AModermVistor v) {
		 try {
			 HayesAcyclicVisitor hayes = (HayesAcyclicVisitor)v;
			 hayes.visit(this);
		 } catch(ClassCastException ex) {
			 throw new RuntimeException(ex);
		 }
	 }
}