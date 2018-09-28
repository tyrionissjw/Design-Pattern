public class ConcreteDecoratorNoComponent extends DecoratorNoComponent {
	 public ConcreteDecoratorNoComponent(ConcreteComponentNoComponent component) {
		 super(component);
	 }
	 
	 public void f() {
		 pre();
		 super.f();
		 after();
	 }
	 
	 public void pre() {
		  System.out.println("Pre NoComponent");
	 }
	 
	 public void after() {
		 System.out.println("after NoComponent");
	 }
}