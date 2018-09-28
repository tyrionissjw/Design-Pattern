public interface ModermVisitor {
	 public void visit(HayezModermNode node);
	 public void visit(ZoomModermNode node);
	 public void visit(ErnleModermNode node);
}

class UnixModermConfiguration implements ModermVisitor {
	 public void visit(HayezModermNode node) {
		 System.out.println("config HayezModermNode to unix");
		 node.dial();
		 node.send();
	 }

	 public void visit(ZoomModermNode node) {
		System.out.println("config ZoomModermNode to unix");
		 node.dial();
		 node.send();
	 }

	 public void visit(ErnleModermNode node) {
		 System.out.println("config ErnleModermNode to unix");
		 node.dial();
		 node.send();
	 }	 
	 	 

}