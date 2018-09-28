public abstract class ProductDecorator implements Product {
	 private Product p;
	 
	 public ProductDecorator(Product p) {
		 this.p = p;
	 }
	 
	 public void doBusiness() {
		 p.doBusiness();
	 }
}