package ThreadsLearning;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

class Producer implements Runnable{
	private BlockingQueue<String> container = null;
	
	public Producer(BlockingQueue<String> que){
		this.container=que;
	}
	@Override
	public void run() {
		String[] products={"Apple","Banana","orange","Grapes","Mango","Done"};
		for(int i=0;i<products.length;i++){
			try {
				System.out.println("producing"+products[i]);
				container.put(products[i]);
				System.out.println(products[i]+"produced");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			container.put("Done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class consumer implements Runnable{
	private BlockingQueue<String> container = null;

	public consumer(BlockingQueue<String> que){
		this.container=que;
	}
	
	@Override
	public void run() {
		try {
			String message = container.take();
			while(!message.equals("Done")){
				System.out.println(message+"consumed");
				message=container.take();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class ProducerConsumerExample{
	public static void main(String[] args){
		SynchronousQueue< String> container = new SynchronousQueue<String>();
		Thread t1 = new Thread(new Producer(container));
		
		Thread t2 = new Thread(new consumer(container));
		t1.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}