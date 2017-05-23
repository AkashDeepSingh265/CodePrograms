package Threads;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		//Thread.dumpStack();
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.start();
		//t.run();
		System.out.println(Thread.currentThread());
		//Thread.dumpStack();
	}

}
