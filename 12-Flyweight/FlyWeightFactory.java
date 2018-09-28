import java.util.*;
public class FlyWeightFactory {
	 private static FlyWeightFactory singleton;
	 private Map<String, FlyWeight> flyWeights;
	 
	 private FlyWeightFactory() {
		 flyWeights = new HashMap<String,FlyWeight>();
	 }
	 
	 public synchronized static FlyWeightFactory newInstance() {
		 if (singleton == null ) {
			 singleton = new FlyWeightFactory();
		 }
		 return singleton;
	 }
	 
	 public synchronized FlyWeight factory(String insideState) {
		 if (flyWeights.containsKey(insideState)) {
			 return flyWeights.get(insideState);
		 } else {
			 FlyWeight fw = new ConcreteFlyWeight(insideState);
			 flyWeights.put(insideState, fw);
			 return fw;
		 }
	 }
	 
	 public void traverse() {
		 Iterator it = flyWeights.entrySet().iterator();
		 int count = 0;
		 while (it.hasNext()) {
			 Map.Entry e =(Map.Entry)it.next();
			 System.out.println(e.getKey()+"  "+e.getValue());			 
			 count++;
		 }
		 System.out.println("总共有享元对象: "+count);
	 }
}