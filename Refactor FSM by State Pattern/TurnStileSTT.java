import java.util.*;
public class TurnStileSTT {
	 // state
	 private static final int LOCKED = 0;
	 private static final int UNLOCKED = 1;
	 // events
	 public static final int COIN = 0;
	 public static final int PASS = 1;
	 
	 private int state = LOCKED;
	 private List<Transition> sttList = new ArrayList<Transition>();
	 private TurnStileController controller; 
	 
	 public TurnStileSTT(TurnStileController controller) {
		 this.controller = controller;
		 addTransition(LOCKED, COIN, UNLOCKED, unLock());
		 addTransition(LOCKED, PASS, LOCKED, alarm());
		 addTransition(UNLOCKED, COIN, UNLOCKED, thankyou());
		 addTransition(UNLOCKED, PASS, LOCKED, Lock());
	 }
	 
	 // 事件处理引擎
	 public void event(int event) {
		 for (Iterator<Transition> it = sttList.iterator() ; it.hasNext() ;) {
			 Transition tran = it.next();
			 if (state == tran.currentState && event == tran.event) {			     
				 state= tran.nextState;				 
				 tran.action.execute();				
				 return;
			 }
		 }
	 }
	 
	 /*
		加入该接口的作用：可以使原动作接口通过内部类的形式继承该接口。如果遇到某个接口不能修改，
		可以使用这种形式为该接口的实现类添加另一种接口
	 */
	 private interface Action {
		 void execute();
	 }
	 
	 private class Transition {	 		 
		 int currentState;
		 int event;
		 int nextState;
		 Action action;
		 
		 public Transition(int currentState, int event, int nextState, Action action) {
			 this.currentState = currentState;
			 this.event = event;
			 this.nextState = nextState;
			 this.action = action;
		 }
	 }
	 
	 public void addTransition(int currentState, int event, int nextState, Action action) {
		 sttList.add(new Transition(currentState, event, nextState, action));
	 }
	 
	 private Action Lock() {
		 return new Action() {
			 public void execute() {
				 doLock();
			 }
		 };
	 }
	 
	 private void doLock() {
		 controller.lock();
	 }
	 
	 private Action unLock() {
		 return new Action() {
			 public void execute() {
				 doUnLock();
			 }
		 };
	 }
	 
	 private void doUnLock() {
		 controller.unLock();
	 }
	 
	 private Action alarm() {
		 return new Action() {
			 public void execute() {
				 doAlarm();
			 }
		 };
	 }
	 
	 private void doAlarm() {
		 controller.alarm();
	 }	 

	 private Action thankyou() {
		 return new Action() {
			 public void execute() {
				 doThankyou();
			 }
		 };
	 }
	 
	 private void doThankyou() {
		 controller.thankyou();
	 }	 	 
	 
	 
}