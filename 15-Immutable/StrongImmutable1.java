import java.util.Date;
public final class StrongImmutable1 {
	 private String state1;
	 private int state2;
	 private Date state3;
	 
	 public StrongImmutable1(String state1, int state2, Date state3) {
		 this.state1 = state1 ;
		 this.state2 = state2;
		 this.state3 = new Date(state3.getTime());
	 }
	 
	 public void show() {
		 System.out.println(state1+" "+state2+" "+state3);
	 }
}