import java.util.*;
public class TransparentComposite implements TransparentCompoent {
	 private TransparentComposite parent;
	 private List<TransparentCompoent> components = new ArrayList<TransparentCompoent>();
	 private static List<TransparentCompoent> children;
	 
	 
	 public List<TransparentCompoent> getBufferedChildren() {
		 if (children == null) {
			 children = Collections.unmodifiableList(components);
		 }
		 return children;		 
	 }
	 
	 public void business() {
		 Iterator<TransparentCompoent> it  = components.iterator();
		 while (it.hasNext()) {
			 TransparentCompoent tc = it.next();
			 tc.business();
		 }
	 }
	 
	 public void setParentComposite(TransparentComposite c) {
		 parent = c;
	 }
	 
	 public TransparentComposite getParentComposite() {
		 return parent;
	 }
	 
	 public void addLeaf(TransparentCompoent c) {
		 components.add(c);		 
		 c.setParentComposite(this);
	 }
	 
	 public void removeLeaf(TransparentCompoent c) {
		 components.remove(c);
		 c.setParentComposite(null);
	 }
}
