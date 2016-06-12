package sequentialValuePrinting;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class printCorrespondingValuesThread {

	public static void main(String[] args){
		ReentrantLock lock = new ReentrantLock();
		//int[] value = {0};
		AtomicInteger sharedValue = new AtomicInteger(0);
		for(int i = 0 ; i <7;i++){
			PrintThread thread1 = new PrintThread(lock, i, sharedValue);
			thread1.start();
			//thread1.setDaemon(true);
		}
//			PrintThread thread2 = new PrintThread(lock, 2, value);
//			PrintThread thread3 = new PrintThread(lock, 3, value);
//			PrintThread thread4 = new PrintThread(lock, 4, value);
//			PrintThread thread5 = new PrintThread(lock, 5, value);
//			PrintThread thread6 = new PrintThread(lock, 6, value);
//			PrintThread thread7 = new PrintThread(lock, 0, value);
//			thread1.start();
//			thread2.start();
//			thread3.start();
//			thread4.start();
//			thread5.start();
//			thread6.start();
//			thread7.start();
		//}
	}
}
