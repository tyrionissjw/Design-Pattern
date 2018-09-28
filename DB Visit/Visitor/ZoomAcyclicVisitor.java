public interface ZoomAcyclicVisitor {
	 public void visit(AZoomModermNode node);
}

class AZoomModermNode implements AModermVistor {
	 public void dial() {
		 System.out.println("AZoomModermNode dial");
	 }
	 
	 public void send() {
		 System.out.println("AZoomModermNode send");
	 }
	 
	 public void accept(AModermVistor v) {
		 try {
			 ZoomAcyclicVisitor zoom = (ZoomAcyclicVisitor)v;
			 zoom.visit(this);
		 } catch(ClassCastException ex) {
			 throw new RuntimeException(ex);
		 }
	 }
}