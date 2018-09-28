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
	 
	 // ����һ���µļ���
	 public int createMemento() {
		 MementorNarrow mementor = originator.createMemento();
		 mens.add(mementor);
		 return current++;		 
	 }
	 
	 // �������˻ָ���ĳ������
	 public void restoreMementor(int index) {
		 MementorNarrow mementor  = mens.get(index);
		 originator.restoreMementor(mementor);
	 }
	 
	 // ɾ��ĳ������
	 public void removeMemento(int index) {
		 mens.remove(index);
	 }
	 

}