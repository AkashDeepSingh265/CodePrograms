package sequentialValuePrinting;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintThread extends Thread{

	private int threadNum;
	private ReentrantLock lock;
	private AtomicInteger value;
	public  PrintThread(ReentrantLock lock , int threadNum,AtomicInteger sharedValue){
		this.lock = lock;
		this.threadNum = threadNum;
		this.value = sharedValue;
	}
	public void run(){
		while(true){
			synchronized (lock) {
				while(value.get()%7!=threadNum){
					//System.out.println("Thread:"+threadNum+" waiting for its turn");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Thread:"+threadNum+" value:"+value.get()%7);
				value.incrementAndGet();
				lock.notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
