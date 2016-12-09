package ChainOfResponsibility;

public class ChainOfResponsibiltyMain {

	public static AbstractLogger getLoggerChainOfResponsibilty(){
		InfoLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
		DebugLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
		ErrorLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		
		infoLogger.setNextLogger(debugLogger);
		debugLogger.setNextLogger(errorLogger);
		
		return infoLogger;
	}
	
	public static void main(String[] args){
		 AbstractLogger loggerChain = getLoggerChainOfResponsibilty();

	      loggerChain.logMessage(AbstractLogger.INFO,"This is an information.");

	      loggerChain.logMessage(AbstractLogger.DEBUG,"This is an debug level information.");

	      loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
	   }
	}

