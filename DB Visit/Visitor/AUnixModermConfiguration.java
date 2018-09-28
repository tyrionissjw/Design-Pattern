public class AUnixModermConfiguration implements AModermVistor,HayesAcyclicVisitor,ZoomAcyclicVisitor,ErnleAcyclicVisitor {	 
	 public void visit(AHayezModermNode node) {
		 System.out.println("config HayezModermNode to unix");
		 node.dial();
		 node.send();
	 }

	 public void visit(AZoomModermNode node) {
		 System.out.println("config ZoomModermNode to unix");
		 node.dial();
		 node.send();
	 }	 
	 
	 public void visit(AErnleModermNode node) {
		 System.out.println("config ErnleModermNode to unix");
		 node.dial();
		 node.send();
	 }	 
}
