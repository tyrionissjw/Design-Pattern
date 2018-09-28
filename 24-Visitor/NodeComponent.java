import java.util.*;
public abstract class NodeComponent implements Node {
	 protected static List<NodeComponent> bufferChildren;
	 
	 public void accept(Visitor v) {
		 for (Iterator<NodeComponent> it = getComposite().iterator() ; it.hasNext(); ) 
			 it.next().accept(v);
	 }
	 
	 protected void add(NodeComponent node) {
		 getComposite().add(node);		 
		 node.setParentComposite(this);
	 }
	 
	 protected void remove(NodeComponent node) {	 
		 getComposite().remove(node);
		 node.setParentComposite(null);
	 }
	 
	 	 
	protected  List<NodeComponent> getBufferedChildren() {
		 if (bufferChildren == null) 
			 bufferChildren = Collections.unmodifiableList(getComposite());
		 return bufferChildren;
	 }
	 
	 protected abstract List<NodeComponent> getComposite();		
	 protected abstract void setComposite(List<NodeComponent> composite);
	 protected abstract void setParentComposite(NodeComponent node) ;
	 protected abstract NodeComponent getParenComposite();	 	 	 	
}