public final class DataBaseFacade {
	 private Product product;
	 private Assembly assembly;
	 
	 public DataBaseFacade(Product product, Assembly assembly) {
		 this.product = product;
		 this.assembly = assembly;
	 }
	 

	 
	 public DataBaseFacade() {
	 }
	 
	 public void setProduct(Product product) {
		 this.product = product;
	 }
	 
	 public void setAssembly(Assembly assembly) {
		 this.assembly = assembly;
	 }
	 
	 public void writeProduct() {
		  ;
	 }
	 public void writeAssembly() {
		 ;
	 }
	 public Product readProduct() {
		 return new Product();
	 }
	 public Assembly readAssembly() {
		 return new Assembly();
	 }
}