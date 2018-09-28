public class TransparentLeaf implements TransparentCompoent {     
	 private TransparentComposite parent;
	 public void business() {
		 System.out.println("this is a leaf");
	 }
	 
	 public void setParentComposite(TransparentComposite c) {
		 parent = c;
	 }
	 
	 public TransparentComposite getParentComposite() {
		 return parent;
	 }
	 
	 public void addLeaf(TransparentCompoent c) {
	     throw new UnsupportedOperationException();		 
	 }
	 
	 public void removeLeaf(TransparentCompoent c) {
		 throw new UnsupportedOperationException();
	 }
}