public class ConcreteDecorator extends Decorator {	 
	 
	 
	 public ConcreteDecorator(Component component) {
		 super(component);
	 }
	 
	 public void f() {
		 preBusiness();
		 super.f();
		 afterBusiness();
	 }
	 
	 private void preBusiness() {
		 System.out.println("Pre");
	 }
	 
	 private void afterBusiness() {
		 System.out.println("After");
	 }
} 