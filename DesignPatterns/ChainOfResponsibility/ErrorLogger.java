package ChainOfResponsibility;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}
	
	@Override
	public void writeMessage(String message) {
		System.out.println("[ErrorLogger] Message:"+message);
	}

}
