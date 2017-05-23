package ThreadsLearning;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
private BlockingQueue<String> sq = new SynchronousQueue<String>();

class PutThread implements Runnable {
	public void run() {
		try {
				System.out.println("Putting value1"+Thread.currentThread().getName());
				sq.put("A");
				System.out.println("Value is put 1");
				System.out.println("Putting value2");
				sq.put("B");
				System.out.println("Value is put2 ");
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
}
class TakeThread implements Runnable {
	public void run() {
		try {
				System.out.println("Taking value 1");
				System.out.println(sq.take());
				System.out.println("value taken1");
				System.out.println(sq.take());
				System.out.println("value taken2");
				Thread.sleep(500);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public static void main(String... args) {
new Thread((new SynchronousQueueTest()).new PutThread()).start();

try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
new Thread((new SynchronousQueueTest()).new TakeThread()).start();}
}