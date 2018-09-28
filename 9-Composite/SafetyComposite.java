import java.util.*;
public class SafetyComposite implements SafetyComponent {
	 private List<SafetyComponent> components = new ArrayList<SafetyComponent>();
	 private SafetyComposite parent;
	 private static List<SafetyComponent> children;
	 	 
	 
	 public List<SafetyComponent> getBufferedChildren() {
		 if (children == null) {
			 children = Collections.unmodifiableList(components);
		 }
		 return children;
	 }
	 
	 public void business() {
		 Iterator<SafetyComponent> it = components.iterator();
		 while(it.hasNext()) {
			 SafetyComponent c = it.next();
			 c.business();
		 }
	 }
	 
	 public void add(SafetyComponent c) {
		 components.add(c);		
		 c.setParentComposite(this);
	 }
	 
	 public void remove(SafetyComponent c) {
		 components.remove(c);
		 c.setParentComposite(null);
	 }
	 	 
	 public SafetyComposite getParentComposite() {
		 return parent;
	 }
	 
	 public void setParentComposite(SafetyComposite c) {
		 parent = c;
	 }
	 
	 
}