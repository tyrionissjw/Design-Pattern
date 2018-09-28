import java.util.*;
public class ConcreteCompositeFlyWeight implements FlyWeight {
	 private Map<String ,FlyWeight> componts = new HashMap<String, FlyWeight>();
	 
	 
		
	 public void f(String outsideState) {		 
		 Collection values = componts.values();
		 for (Iterator it = values.iterator() ; it.hasNext() ;) {
			 FlyWeight fw = (FlyWeight)it.next();
			 fw.f(outsideState);
		 }		 
	 }
	 
	 public void add(String outsideState, FlyWeight fw) {
		 componts.put(outsideState, fw);
	 }
	 
	 public FlyWeight remove(String outsideState) {		
		 return componts.remove(outsideState);
	 }
	 
	 public void traverse() {
		  Iterator it = componts.entrySet().iterator();
		 while (it.hasNext()) {
			 Map.Entry e =(Map.Entry)it.next();
			 System.out.println(e.getKey()+"  "+e.getValue());			 
		 }
	 }
	 
}