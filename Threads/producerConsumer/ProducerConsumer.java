package producerConsumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args){
		Queue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(10);
		int[] sharedValue = {0};
		Producer producer = new Producer(sharedQueue,sharedValue);
		Consumer consumer = new Consumer(sharedQueue,sharedValue);
		consumer.start();
		producer.start();
	}
}
