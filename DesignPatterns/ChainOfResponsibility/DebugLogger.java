package ChainOfResponsibility;

public class DebugLogger extends AbstractLogger {

	public DebugLogger(int level){
		this.level = level;
	}
	public void writeMessage(String message) {
		System.out.println("[DebugLogger] Message :"+message);
	}

}
