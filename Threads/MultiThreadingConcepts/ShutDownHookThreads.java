package MultiThreadingConcepts;

public class ShutDownHookThreads {

	public static void main(String[] args){
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			public void run() {
				System.out.println("Fuck the world i am going to die bitch !!!");
			}
		}));
		
		for(int i=0;i<5;i++){
			System.out.println("chutiaapy going on");
		}
	}
}
