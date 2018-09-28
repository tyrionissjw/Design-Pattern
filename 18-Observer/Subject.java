public interface Subject {	
	 public void notifyObservers();
	 public boolean attach(Observer o);
	 public boolean delete(Observer o);
}
