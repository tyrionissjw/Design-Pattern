import java.util.*;
public class ConcreteMacroCommand implements MacroCommand {
	 private List commandList = Collections.synchronizedList(new LinkedList());
	 
	 public void execute() {
		 Iterator it = commandList.iterator();
		 while (it.hasNext()) {
			 Command c = (Command)it.next();
			 c.execute();
		 }
	 }
	 
	 public void add(Command toAdd) {
		 commandList.add(toAdd);
	 }
	 
	 public void remove(Command toRemove) {
		 commandList.remove(toRemove);
	 }
}