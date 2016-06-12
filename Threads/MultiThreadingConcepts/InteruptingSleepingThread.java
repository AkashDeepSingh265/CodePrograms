package MultiThreadingConcepts;

public class InteruptingSleepingThread {

	public static void main(String[] args){
		Thread mythread = new Thread(new Runnable() {
			
			public void run() {
				while(true){
					System.out.println(".");
//					try {
//						//Thread.sleep(100);
//					} catch (InterruptedException e) {
//						break;
//					}
				}
			}
		});
		mythread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mythread.interrupt();
	}
}
