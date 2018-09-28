public class ConcreteBuilder implements Builder {
     private Product p = new ConcreteProduct();
	 
     public void buildPartA() {	 
	 }
	 
	 public void buildPartB() {
	 }
	 
	 public Product retrieveResult() {
	     return p;
	 }
}