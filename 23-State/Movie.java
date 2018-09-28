public interface Movie {
	 public void showPrice();
}

class ConcreteMovie1 implements Movie {
	 public void showPrice() {
		 System.out.println("ConcreteMovie1 is $100");
	 }
}

class ConcreteMovie2 implements Movie {
	 public void showPrice() {
		 System.out.println("ConcreteMovie2 is $200");
	 }
}

class ConcreteMovie3 implements Movie {
	 public void showPrice() {
		 System.out.println("ConcreteMovie3 is $300");
	 }
}
