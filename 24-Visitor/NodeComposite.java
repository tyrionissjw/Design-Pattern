import java.util.*;
public class NodeComposite extends NodeComponent {
	 private List<NodeComponent> composite = new ArrayList<NodeComponent>();
	 private NodeComponent parent;
	 
	 public List<NodeComponent> getComposite() {
		 return composite;
	 }
	 	 
	 public void setComposite(List<NodeComponent> composite) {
		 this.composite = composite;
	 }
	 
	 public void setParentComposite(NodeComponent node)  {
		 this.parent = node;
	 }
	 	
	 public NodeComponent getParenComposite() {
		 return parent;
	 }
	 


	 
}