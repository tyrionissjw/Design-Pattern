public class EmployeeRef3 {
	 private EmployeeTypeRef3 type;
	 private int monthlySalary;
	 private int commission;
	 private int bonus;
	 
	 public EmployeeRef3(int type) {
		 setType(type);
	 }
	 
	 public int getType() {
		 return type.getTypeCode();
	 }
	 
	 public void setType(int arg) {
		 type = EmployeeTypeRef3.newType(arg);
	 }
	 
	 public int pay() {
		 return type.pay(this);
	 }
	 
	 public int getMonthlySalary() {
		 return monthlySalary;
	 }
	 
	 public int getCommission() {
		 return commission;
	 }
	 
	 public int getBouns() {
		 return bonus;
	 }

}

abstract class  EmployeeTypeRef3 {	 
	 static final int ENGINEER = 0;
	 static final int SALEMAN = 1;
	 static final int MANAGER = 2;
	 
	 public static EmployeeTypeRef3 newType(int code) {
		 switch(code) {
			 case ENGINEER:
				 return new EngineerStateRef3();
			 case SALEMAN:
				 return new SalemanStateRef3();
			 case MANAGER:
				 return new ManagerStateRef3();
			 default :
				 throw new IllegalArgumentException("wrong type");
		 }
	 }
	 abstract int getTypeCode();
	 abstract int pay(EmployeeRef3 emp);
}

class SalemanStateRef3 extends EmployeeTypeRef3 {
	 int getTypeCode() {
		 return EmployeeTypeRef3.SALEMAN;
	 }

	 int pay(EmployeeRef3 emp) {
		 return emp.getMonthlySalary() + emp.getCommission();
	 }	 
}

class EngineerStateRef3 extends EmployeeTypeRef3 {
	 int getTypeCode() {
		 return EmployeeTypeRef3.ENGINEER;
	 }
	 
	 int pay(EmployeeRef3 emp) {
		 return emp.getMonthlySalary();
	 }
}

class ManagerStateRef3 extends EmployeeTypeRef3 {
	 int getTypeCode() {
		 return EmployeeTypeRef3.MANAGER;
	 }
	 
	 int pay(EmployeeRef3 emp) {
		 return emp.getMonthlySalary() + emp.getBouns();
	 }	 
}