public class IFactory implements TopFactory {   
    public Product createProduct1() {
	      return new IProduct();
	}
	
	public Product createProduct2() {
	       return new IProduct("abc");
	}
}