public interface Price {
	 public void getCharge();	 
}

class Price1 implements Price {
	 public void getCharge() {
		 System.out.println("getCharge $100");
	 }
}

class Price2 implements Price {
	 public void getCharge() {
		 System.out.println("getCharge $200");
	 }
}

class Price3 implements Price {
	 public void getCharge() {
		 System.out.println("getCharge $300");
	 }
}