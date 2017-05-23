
public class TestThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Running");
	}
	
	public static void main(String[] args ){
		Thread t = new Thread(new TestThread());
		t.run();t.run();t.start();
	}

}
