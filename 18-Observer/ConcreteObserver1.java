public class ConcreteObserver1 implements Observer {
	 public void update() {
		 System.out.println("update ConcreteObserver1");
	 }
	
	 public boolean equals(Object otherObj) {
		 if (otherObj == null)
			 return false;
		 if (otherObj == this)
			 return true;
		 if (otherObj != getClass())
			 return false;			 
		 return true;
	 }
}
