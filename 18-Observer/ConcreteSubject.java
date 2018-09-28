import java.util.*;
public class ConcreteSubject implements Subject {
	 private List<Observer> observers = new LinkedList<Observer>();

	 public void notifyObservers() {		 
		 for ( Iterator it = observers.iterator() ; it.hasNext(); ) {
			 Observer o = (Observer)it.next();
			 o.update();
		 }
	 }
	 
	 public boolean attach(Observer o) {
		 /*
			确保此 collection 包含指定的元素（可选操作）。
			如果此 collection 由于调用而发生更改，则返回 true。（如果此 collection 不允许有重复元素，并且已经包含了指定的元素，则返回 false。)
			如果 collection 由于某些原因（已经包含该元素的原因除外）拒绝添加特定的元素，那么它必须 抛出一个异常（而不是返回 false）。
			这确保了在此调用返回后，collection 总是包含指定的元素。 
		 */
		 return observers.add(o);
	 }
	 
	 public boolean delete(Observer o) {	 
	     /*
			 从此列表中移除第一次出现的指定元素（如果存在）（可选操作）。
			 如果列表不包含元素，则不更改列表。更确切地讲，移除满足 (o==null ? get(i)==null : o.equals(get(i))) 的最低索引 i 的元素（如果存在这样的元素）。
			 如果此列表已包含指定元素（或者此列表由于调用而发生更改），则返回 true。 
		 */
		 return observers.remove(o);
	 }
	 
	 public List getObservers() {
		 return Collections.unmodifiableList(observers);
	 }
}