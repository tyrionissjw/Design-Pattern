public class ObjAdapter extends Target {
	 private Adaptee source;
	 
	 public ObjAdapter(Adaptee source) {
		 this.source = source;
	 }	 	
	 
	 public void f() {
		 source.f();
	 }
	 
	 public void business() {
		 System.out.println("Adapter自己实现");
	 }
	 
	 public void setSource(Adaptee source) {
		 this.source = source;
	 }
}