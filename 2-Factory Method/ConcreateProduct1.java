public class ConcreateProduct1 implements MiddleProduct {
     public ConcreateProduct1() {
	 }
	 
	 public ConcreateProduct1(String s) {
	     System.out.println("ConcreateProduct1 string"+s);
	 }
	 
	 public ConcreateProduct1(int i) {
	     System.out.println("ConcreateProduct1 int"+i);  
	 }
	 
	public void business() {
        System.out.println("this is ConcreateProduct1 business");
    }        
	
	public void business1() {
        System.out.println("this is ConcreateProduct1 business1");
   }        
}