import java.util.Date;
public  class StrongImmutable3 {
	 private String state1;
	 private int state2;
	 private Date state3;
	 	 
	 private StrongImmutable3(String state1, int state2, Date state3) {
		 this.state1 = state1 ;
		 this.state2 = state2;
		 this.state3 = new Date(state3.getTime());
	 }
	 
	 public final void show() {
		 System.out.println(state1+" "+state2+" "+state3);
	 }
	 
	 public static StrongImmutable3 getInstance(String state1, int state2, Date state3) {
		 return new StrongImmutable3(state1, state2, state3);
	 }
}