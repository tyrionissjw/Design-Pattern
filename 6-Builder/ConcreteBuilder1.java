public class ConcreteBuilder1 implements Builder {
     private Product p = new ConcreteProduct1();
	 
     public void buildPartA() {	 
	 }
	 
	 public void buildPartB() {
	 }
	 
	 public Product retrieveResult() {
	     return p;
	 }
}