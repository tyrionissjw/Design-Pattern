public interface TurnStileState {
	 public void coin(TurnStileContext context);
	 public void pass(TurnStileContext context);
}

class LockTurnStileState implements TurnStileState {
	 public void coin(TurnStileContext context) {
		 context.setUnLocked();
		 context.unLock();
	 }
	 
	 public void pass(TurnStileContext context) {
		 context.alarm();
	 }
}

class UnLockTurnStileState implements TurnStileState {
	 public void coin(TurnStileContext context) {
		 context.thankyou();
	 }
	 
	 public void pass(TurnStileContext context) {
		 context.setLocked();
		 context.lock();
	 }
}