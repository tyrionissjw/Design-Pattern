public class TurnStile {
	 // state
	 private static final int LOCKED = 0;
	 private static final int UNLOCKED = 1;
	 // events
	 public static final int COIN = 0;
	 public static final int PASS = 1;
	 
	 private TurnStileController controller;
	 private int state = LOCKED;
	 
	 public TurnStile(TurnStileController controller) {
		 this.controller = controller;
	 }
	 
	 public void event(int event) {
		 switch(state) {
			 case LOCKED:
				 switch(event) {
					 case COIN:
						 state = UNLOCKED;
						 controller.lock();
						 break;
					 case PASS:
						 controller.alarm();
						 break;
				 }
			 break;
			 case UNLOCKED:
				 switch(event) {
					 case COIN:
					     controller.thankyou();
						 break;
					 case PASS:
						 state = LOCKED;
						 controller.lock();
						 break;
				 }
			 break;
		 }
	 }
}