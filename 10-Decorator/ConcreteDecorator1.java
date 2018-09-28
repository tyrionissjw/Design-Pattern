public class ConcreteDecorator1 extends Decorator {

	 public ConcreteDecorator1(Component c) {
		 super(c);
	 }
	 
	 public void f() {
	     preBusiness();
		 super.f();
		 afterBusiness();
	 }
	 
	 private void preBusiness() {
		 System.out.println("Pre1");
	 }
	 
	 private void afterBusiness() {
		 System.out.println("After1");
	 }
}