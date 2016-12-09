package ObserverPattern;

public class ObserverPatternDemo {
	public static void main(String[] args){
		Subject subject = new Subject();
		new BinaryObserver(subject);
		new OctalObserver(subject);
		new HexaObserver(subject);
		
		System.out.println("Changing subject value to 15");
		subject.setState(15);
		System.out.println("Changing subject value to 20");
		subject.setState(20);
	}
}
