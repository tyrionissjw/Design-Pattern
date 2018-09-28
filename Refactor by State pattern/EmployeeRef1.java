public class EmployeeRef1 {
	 private int type;
	 static final int ENGINEER = 0;
	 static final int SALEMAN = 1;
	 static final int MANAGER = 2;
	 
	 private EmployeeRef1(int type) {
		 this.type = type;
	 }
	 
	 public EmployeeRef1() {
	 }
	 
	 public static EmployeeRef1 create(int type){
		 switch(type) {
			 case ENGINEER:
				 return new ENGINEER();
			 case SALEMAN:
				 return new SALEMAN();
			 case MANAGER:
				 return new MANAGER();
			 default :
				 throw new IllegalArgumentException("wrong type");
		 }
	 }
	 
	 public int getType() {
		 return type;
	 }
}

class ENGINEER extends EmployeeRef1 {	 
	private String Engineer_field;
	
	 public int getType() {
		 return EmployeeRef1.ENGINEER;
	 }	 
	 
	 public void Enginner_business() {
		 System.out.println(Engineer_field);
	 }	 	 	 
}

class SALEMAN extends EmployeeRef1 {	 
	private String Saleman_field;
	
	 public int getType() {
		 return EmployeeRef1.SALEMAN;
	 }	 
	 
	 public void Saleman_business() {
		 System.out.println(Saleman_field);
	 }	 	 	 
}

class MANAGER extends EmployeeRef1 {	 
	private String Manager_field;
	
	 public int getType() {
		 return EmployeeRef1.MANAGER;
	 }	 
	 
	 public void Manager_business() {
		 System.out.println(Manager_field);
	 }	 	 	 
}