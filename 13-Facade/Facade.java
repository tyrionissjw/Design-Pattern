public class Facade {
	 private SubSystem1 s1;
	 private SubSystem2 s2;
	 
	 private static Facade singleton;
	 
	 private Facade() {
	 }
	 
	 private Facade(SubSystem1 s1, SubSystem2 s2) {
		 this.s1 = s1;
		 this.s2 = s2;
	 }
	 
	 public synchronized static Facade newInstance(SubSystem1 s1, SubSystem2 s2) {
		 if (singleton == null) {
			 singleton = new Facade(s1, s2);
		 }
		 return singleton;
	 }
}