package Threads;

class ThreadNotify extends Thread{
	public void run(){
		synchronized (this) {
			System.out.println("Starting executing");
			for(int i = 0 ; i < 100 ; i ++){
				System.out.println(i);
			}
			System.out.println("completed Execution");
			notify();
			for(int i = 0 ; i < 10 ; i ++){
				System.out.println("After Notify");
			}
		}
	}
}
public class NotifyWait {
	
	public static void main(String[] args){
		ThreadNotify t = new ThreadNotify();
		t.start();
		
		synchronized (t) {
			System.out.println("Lock taken . Waiting for Notify");
			try {
				t.wait();
				System.out.println("Recieved notify . Wait over");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
