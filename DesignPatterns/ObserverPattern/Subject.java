package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private int state;
	private List<Observer> observers = new ArrayList<Observer>();
	public void attachObserver(Observer observer){
		this.observers.add(observer);
	}
	
	public void setState(int state){
		this.state = state;
		notifyAllObservers();
	}

	public int getState(){
		return state;
	}
	private void notifyAllObservers() {
		for(Observer ob: observers){
			ob.update();
		}
	}
}
