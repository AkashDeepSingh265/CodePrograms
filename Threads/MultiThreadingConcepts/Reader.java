package MultiThreadingConcepts;

class Calculator extends Thread{
	int total;
	
	public void run(){
		synchronized(this){
			System.out.println("calcultaing sum...");
			for(int i=0;i<100;i++)
				total +=i;
			notifyAll();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
public class Reader extends Thread{
	Calculator cal;
	
	public Reader(Calculator c){
		this.cal = c;
	}
	
	public void run(){
		System.out.println("Waiting to get lock for:"+Thread.currentThread().getName());
		synchronized (cal) {
			System.out.println("Waiting for calculation ..."+Thread.currentThread().getName());
			try {
				cal.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Total for :"+Thread.currentThread().getName()+" is:"+cal.total);
		}
	}
	
	public static void main(String[] args){
		Calculator cal = new Calculator();
		Reader r1 = new Reader(cal);
		Reader r2 = new Reader(cal);
		Reader r3 = new Reader(cal);
		r1.start();
		System.out.println("Thread1 started");
		r2.start();
		System.out.println("Thread2 started");
		r3.start();
		System.out.println("Thread3 started");
		cal.start();
		
		
	}
}
