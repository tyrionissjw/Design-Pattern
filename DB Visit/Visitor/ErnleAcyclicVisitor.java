public interface ErnleAcyclicVisitor {
	 public void visit(AErnleModermNode node);
}

class AErnleModermNode implements AModermVistor {
	 public void dial() {
		 System.out.println("AErnleModermNode dial");
	 }
	 
	 public void send() {
		 System.out.println("AErnleModermNode send");
	 }
	 
	 public void accept(AModermVistor v) {
		 try {
			 ErnleAcyclicVisitor ernle = (ErnleAcyclicVisitor)v;
			 ernle.visit(this);
		 } catch(ClassCastException ex) {
			 throw new RuntimeException(ex);
		 }
	 }
}