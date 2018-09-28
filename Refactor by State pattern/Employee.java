public class Employee {
	 private int type;
	 static final int ENGINEER = 0;
	 static final int SALEMAN = 1;
	 static final int MANAGER = 2;
	 
	 private String Engineer_field;
	 private String Saleman_field;
	 private String Manager_field;
	 
	 public Employee(int type) {
		 this.type = type;
	 }
	 
	 public void doBusiness() {
		 switch(type) {
			 case ENGINEER:
				 Enginner_business();
				 break;
			 case SALEMAN:
				 Saleman_business();
				 break;
			 case MANAGER:
				 Manager_business();
				 break;
			 default:
				 throw new IllegalArgumentException("wrong type");
		 }
	 }
	 
	 public void Enginner_business() {
		 System.out.println(Engineer_field);
	 }
	 
	 public void Saleman_business() {
		 System.out.println(Saleman_field);
	 }

	 public void Manager_business() {
		 System.out.println(Manager_field);
	 }	 
}