public class TurnStileContext  {
	 private static TurnStileState lockState = new LockTurnStileState();
	 private static TurnStileState unLockState= new UnLockTurnStileState();
	 
	 private TurnStileController controller;
	 private TurnStileState state = lockState;
	 
	 public TurnStileContext(TurnStileController controller) {
		 this.controller = controller;
	 }
	 
	 public void coin() {
		 state.coin(this);
	 }
	 
	 public void pass() {
		 state.pass(this);
	 }
	 
	 public void setLocked() {
		 state = lockState;
	 }
	 
	 public void setUnLocked() {
		 state  = unLockState;
	 }
	 
	 
	 
	 protected void lock() {
		 controller.lock();
	 }
	 	 
	 protected void unLock() {
		 controller.unLock();
	 }

	 protected void alarm() {
		 controller.alarm();
	 }	 

	 protected void thankyou() {
		 controller.thankyou();
	 }	 	 	 
	 
	 
	 public void event() {
		 ;
	 }
}	 