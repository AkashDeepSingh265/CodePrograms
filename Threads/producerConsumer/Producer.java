package producerConsumer;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

	private Queue<Integer> sharedQueue;
	private  int[] sharedValue;
	
	public Producer(Queue<Integer> queue, int[] sharedValue2){
		this.sharedQueue = queue;
		this.sharedValue = sharedValue2;
		
	}
//	public void run() {
//		//for(int i = 0 ; i < 10 ; i ++){
//		while(true){
//			synchronized (sharedQueue) {
//				while(sharedQueue.size()==10){
//					System.out.println("Producer waiting for queue to get Empty");
//					try {
//						sharedQueue.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				int i = new Random().nextInt();
//				System.out.println("Producing value:"+i);
//				sharedQueue.add(i);
//				sharedQueue.notifyAll();
//			}
////			try {
////				//Thread.sleep(100);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//		}
//	}
	
	//print odd
	public void run() {
		while(true){
			synchronized (sharedQueue) {
				while(sharedValue[0]%2==0){
					System.out.println("Thread 1 waiting for its turn");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Thread1:"+sharedValue[0]);
				sharedValue[0]++;
				sharedQueue.notifyAll();
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
