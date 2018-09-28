public class DBDecorator extends ProductDecorator {	 
	 public DBDecorator(Product p)  {
		 super(p);
	 }
	 
	 public void doBusiness() {
		 read();
		 super.doBusiness();
		 write();
	 }
	 
	 // readDB
	 public void read() {
		 System.out.println("read DB");
	 }
	 
	 // writeDB
	 public void write() {
		 System.out.println("write DB");
	 }
	 
}