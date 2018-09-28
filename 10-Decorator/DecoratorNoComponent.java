public abstract class DecoratorNoComponent extends ConcreteComponentNoComponent {
	 private ConcreteComponentNoComponent compoent;
	 
	 public DecoratorNoComponent(ConcreteComponentNoComponent compoent) {
		 this.compoent = compoent;
	 }
	 
	 public void f() {
		 compoent.f();
	 }
}