public class IMiddleFactory implements MiddleFactory {
         public MiddleProduct createMiddleProduct () {
		     return new ConcreateProduct1(1);
		 }
		 
		 public Product createProduct1() {
		     return new ConcreateProduct1();
		 }
		 
		 public Product createProduct2() {
		     return new ConcreateProduct1("str");
		 }
}