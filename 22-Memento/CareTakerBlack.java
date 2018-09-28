import java.util.*;
public class CareTakerBlack {	 
	 private List<MementorNarrow> mens = new ArrayList<MementorNarrow>();
	 private int current;
	 private OriginatorBlack originator;
	  
	 public CareTakerBlack(OriginatorBlack originator) {
		 this.originator = originator;
	 }
	 
	 
	 public MementorNarrow retreiveMementor(int index) {
		 return mens.get(current);
	 }
	 
	 // 创建一个新的检查点
	 public int createMemento() {
		 MementorNarrow mementor = originator.createMemento();
		 mens.add(mementor);
		 return current++;		 
	 }
	 
	 // 将发起人恢复到某个检查点
	 public void restoreMementor(int index) {
		 MementorNarrow mementor  = mens.get(index);
		 originator.restoreMementor(mementor);
	 }
	 
	 // 删除某个检查点
	 public void removeMemento(int index) {
		 mens.remove(index);
	 }
	 

}