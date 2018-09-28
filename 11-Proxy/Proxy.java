public class Proxy implements Subject {
	 private RealSubject sub;
	 
	
	 public void f() {
		 pref();
		 if (sub == null) {
			 sub = new RealSubject();
		 }
		 sub.f();
	 }
	 
	 public void pref() {
		 System.out.println("pre");
	 }
}