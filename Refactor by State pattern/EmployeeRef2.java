public class EmployeeRef2 {
	 private EmployeeType type;
	 private int monthlySalary;
	 private int commission;
	 private int bonus;
	 
	 public EmployeeRef2(int type) {
		 setType(type);
	 }
	 
	 public int getType() {
		 return type.getTypeCode();
	 }
	 
	 public void setType(int arg) {
		 type = EmployeeType.newType(arg);
	 }

	 public int pay() {
		 switch(getType()) {
			 case EmployeeType.ENGINEER:
				 return monthlySalary;
			 case EmployeeType.SALEMAN:
				 return  monthlySalary+commission;
			 case EmployeeType.MANAGER:
				 return monthlySalary+bonus;
			 default :
				 throw new IllegalArgumentException("wrong type");				 
		 }
	 }
}

abstract class  EmployeeType {	 
	 static final int ENGINEER = 0;
	 static final int SALEMAN = 1;
	 static final int MANAGER = 2;
	 
	 public static EmployeeType newType(int code) {
		 switch(code) {
			 case ENGINEER:
				 return new EngineerState();
			 case SALEMAN:
				 return new SalemanState();
			 case MANAGER:
				 return new ManagerState();
			 default :
				 throw new IllegalArgumentException("wrong type");
		 }
	 }
	 abstract int getTypeCode();
}

class SalemanState extends EmployeeType {
	 int getTypeCode() {
		 return EmployeeType.SALEMAN;
	 }
}

class EngineerState extends EmployeeType {
	 int getTypeCode() {
		 return EmployeeType.ENGINEER;
	 }
}

class ManagerState extends EmployeeType {
	 int getTypeCode() {
		 return EmployeeType.MANAGER;
	 }
}
