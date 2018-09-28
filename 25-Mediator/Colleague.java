public abstract class Colleague {
	 public Colleague() {
	 }
	 
	 public Colleague(Mediator m) {
		 setMediator(m);
	 }
	 
	 public void changed() {
		 getMediator().colleagueChanged(this);
	 }
	 
	 public abstract void action();
	 public abstract void setMediator(Mediator m);
	 public abstract Mediator getMediator();
}