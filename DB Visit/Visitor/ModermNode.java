public interface ModermNode extends Moderm {
	 public void accept(ModermVisitor v);
}


class HayezModermNode implements ModermNode {
	 public void dial() {
		 System.out.println("HayezModermNode dial");
	 }
	 
	 public void send() {
		 System.out.println("HayezModermNode send");
	 }
	 
	 public void accept(ModermVisitor v) {
		 v.visit(this);
	 }
}

class ZoomModermNode implements ModermNode {
	 public void dial() {
		 System.out.println("ZoomModermNode dial");
	 }
	 
	 public void send() {
		 System.out.println("ZoomModermNode send");
	 }
	 
	 public void accept(ModermVisitor v) {
		 v.visit(this);
	 }	 
}

class ErnleModermNode implements ModermNode {
	 public void dial() {
		 System.out.println("ErnleModermNode dial");
	 }
	 
	 public void send() {
		 System.out.println("ErnleModermNode send");
	 }
	 
	 public void accept(ModermVisitor v) {
		 v.visit(this);
	 }	 
}