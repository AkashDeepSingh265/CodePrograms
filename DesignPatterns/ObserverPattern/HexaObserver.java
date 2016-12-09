package ObserverPattern;

public class HexaObserver extends Observer{

	public HexaObserver(Subject subject){
		this.subject = subject;
		this.subject.attachObserver(this);
	}

	@Override
	public void update() {
		System.out.println("HexaValue:"+Integer.toHexString(subject.getState()));
	}
}
