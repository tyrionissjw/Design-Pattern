public class SafetyLeaf implements SafetyComponent {
	 private SafetyComposite parent;
	 
	 public SafetyComposite getParentComposite() {
		 return parent;
	 }
	 
	 public void setParentComposite(SafetyComposite c) {
		 parent = c;
	 }
	 
	 public void business() {
		 System.out.println("this is a leaf");
	 }
}