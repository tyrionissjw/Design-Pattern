import java.util.*;
public class CommandWithUndo implements Undoable {
	 private List undoList = Collections.synchronizedList(new LinkedList());
	 private List redoList = Collections.synchronizedList(new LinkedList());
	 private Receiver recv;
	 
	 public CommandWithUndo(Receiver recv) {
		 this.recv = recv;
	 }
	 
	 public void execute() {
		 recv.action();		 
		 undoList.add(this);		 
	 }
	 
	 public void undo() {
		 if (undoList.size() <= 0 )
			 return;
		 Command cmd = (Command)undoList.get(undoList.size()-1);
		 doUndo();
		 redoList.add(cmd);
	 }
	 
	 private void doUndo() {
		 System.out.println("Undo!");
	 }
	 
	 public void redo() {
		 if (redoList.size() <=0) 
			 return;
		 Command cmd = (Command)redoList.get(redoList.size()-1);
		 doRedo();
		 undoList.add(cmd);
	 }
	 
	 private void doRedo() {
		 System.out.println("Redo!");
	 }
	 
}