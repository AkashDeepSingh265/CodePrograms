package producerConsumer;

import java.util.Queue;

public class Consumer extends Thread {
	
	private Queue<Integer> sharedQueue;
	private volatile int[] sharedValue;
	
	public Consumer(Queue<Integer> queue, int[] sharedValue2){
		this.sharedQueue = queue;
		this.sharedValue = sharedValue2;
	}

//	public void run() {
//		//for(int i = 0 ; i < 10 ; i++){
//		while(true){
//			synchronized (sharedQueue) {
//				while(sharedQueue.size()==0){
//					try {
//						System.out.println("Waiting for producer to produce items");
//						sharedQueue.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				System.out.println("consuming:"+sharedQueue.remove());
//				sharedQueue.notifyAll();
//			}
////			try {
////				Thread.sleep(100);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//		}
//	}
	
	//print even
	public void run() {
		while(true){
			synchronized (sharedQueue) {
				while(sharedValue[0]%2==1){
					System.out.println("Thread 2 waiting for its turn");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Thread2:"+sharedValue[0]);
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
