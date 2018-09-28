public class Employee1 {
	 private int type;
	 static final int ENGINEER = 0;
	 static final int SALEMAN = 1;
	 static final int MANAGER = 2;
	 
	 private int monthlySalary;
	 private int commission;
	 private int bonus;
	 
	 public Employee1(int type) {
		 this.type = type;
	 }

	 public int pay() {
		 switch(type) {
			 case ENGINEER:
				 return monthlySalary;
			 case SALEMAN:
				 return  monthlySalary+commission;
			 case MANAGER:
				 return monthlySalary+bonus;
			 default :
				 throw new IllegalArgumentException("wrong type");				 
		 }
	 }
}


