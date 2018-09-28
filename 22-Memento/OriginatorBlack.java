import java.util.*;
public class OriginatorBlack {
	 private List<String> states = new ArrayList<String>();
	 private int index;
	 
	 public MementorNarrow createMemento() {
		 return new MementorBlack(states, index);
	 }
	 
	 public void restoreMementor(MementorNarrow m) {		
		 MementorBlack mementor = (MementorBlack)m;
		 states = mementor.getStates();
		 index = mementor.getIndex();
	 }
	 
	 public void addStates(String s) {
		 states.add(s);
		 index++;
	 }
	 
	 public void print() {
		 System.out.println("start...");
		 for (Iterator<String> it = states.iterator() ; it.hasNext();) 
			 System.out.println(it.next());
		 System.out.println("end...");
	 }

	 
protected class MementorBlack implements MementorNarrow {
	 private List<String> states = new ArrayList<String>();
	 private int index;
	 
	 private MementorBlack(List<String> states, int index) {		 
		 this.states = deepClone(states);
		 this.index = index;
	 }
	 
	 private List<String> deepClone(List<String> srcList) {
		 List<String> destList = new ArrayList<String>();
		 for (int i=0 ; i<srcList.size() ; i++) 
			 destList.add(srcList.get(i));
         return  destList; 
	 }
	 
	 private List<String> getStates() {
		 return states;
	 }
	 
	 private int getIndex() {
		 return index;
	 }
	 
	 private void setStates(List<String> states) {
		 this.states = states;
	 }
	 
	 private void setIndex(int index) {
		 this.index = index;
	 }
}
	 
}