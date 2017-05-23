package ThreadsLearning;

public class TestThread implements Runnable {

	@Override
	public void run() {
		int i=0;
		while(true){
			System.out.println(i);
			i++;
			if(Thread.interrupted()){
				System.out.println("Thread is interupted So existing "+ Thread.currentThread().getName());
				return;
			}
		}

		
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting main thread named "+Thread.currentThread().getName());
		Thread.sleep(1000);
		Thread t = new Thread(new TestThread());
		t.start();
		try {
			t.join(1000);
			if(t.isAlive()){
				System.out.println("waited for 1000 ms so stopping execution of "+t.getName());
				t.interrupt();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
