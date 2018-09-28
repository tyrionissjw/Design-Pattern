public class Product {
	 private String part1;
	 private String part2;
	 private DataBaseFacade dbfacade;
	 
	 public void setDbfacade(DataBaseFacade dbfacade) {
		 this.dbfacade = dbfacade;
	 }
	 
	 
	 
	 public String getPart1() {
		 return part1;
	 }
	 
	 public String getPart2() {
		 return part2;
	 }
	 
	 public void setPart1() {
		 this.part1 = part1;
	 }
	 
	 public void setPart2() {
		 this.part2 = part2;
	 }
}