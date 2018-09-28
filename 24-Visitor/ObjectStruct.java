import java.util.*;
public class ObjectStruct {
	 private List<Node> nodes = new ArrayList<Node>();
	 
	 public void add(Node node) {
		 nodes.add(node);
	 }
	 
	 public void action(Visitor v) {
		 for (Iterator<Node> it = nodes.iterator() ; it.hasNext(); ) 
			 it.next().accept(v);		 
	 }
}