public abstract class Template {
	 public void templateMethod() {
		 abstractMethod();
		 String result = abstractMethod1();
		 System.out.println(result);
		 concreteMethod();
		 hookMethod();
	 }
	 
	 protected abstract void abstractMethod();
	 protected abstract String abstractMethod1();
	 private void concreteMethod() {
		 System.out.println("This is a concreteMethod In Template");
	 }
	 protected void hookMethod() {
	 }
	 
}