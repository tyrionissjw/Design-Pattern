import java.util.*;
public class CompositeFlyWeightFactory {
	 private static CompositeFlyWeightFactory singleton;
	 private Map<String, FlyWeight> flyWeights;	 
	 
	 
	 private CompositeFlyWeightFactory() {
		 flyWeights = new HashMap<String, FlyWeight>();		 
	 }
	 
	 public synchronized static CompositeFlyWeightFactory newInstance() {
		 if (singleton == null) {
			 singleton = new CompositeFlyWeightFactory();
		 }
		 return singleton;
	 }
	 
	 public FlyWeight factory(List insideStateList) {
		 Iterator it = insideStateList.iterator();
		 ConcreteCompositeFlyWeight fwComp = new ConcreteCompositeFlyWeight();
		 while (it.hasNext()) {
			 String key = (String)it.next();			 
			 fwComp.add(key, this.factory(key));
		 }		 
		 return fwComp;
	 }
	 	 	
	 public FlyWeight factory(String insideState) {
		 if (flyWeights.containsKey(insideState)) {
			 return flyWeights.get(insideState);
		 } else {
			 FlyWeight fw = new ConcreteFlyWeight(insideState);
			 flyWeights.put(insideState, fw);
			 return fw;
		 }
	 }
}