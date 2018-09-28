public class Director {
     private Builder builder;
	 
	 public Director() {
	 }
	 
	 public Director(Builder builder) {
	     this.builder = builder;
	 }
	 
     public Product construct() {
	     builder.buildPartA();
		 builder.buildPartB();
		 return builder.retrieveResult();
	 }
}