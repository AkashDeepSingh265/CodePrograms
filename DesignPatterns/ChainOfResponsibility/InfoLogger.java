package ChainOfResponsibility;

public class InfoLogger extends AbstractLogger {

	public  InfoLogger(int level) {
		this.level = level;
	}
	@Override
	public void writeMessage(String message) {
		System.out.println("[InfoLogger] Message:"+message);
	}

}
