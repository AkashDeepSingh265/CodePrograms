package Threads;

public class SynchronizedPrint implements Runnable {

	private StringBuffer str;
	public SynchronizedPrint(StringBuffer strBuf){
		str = strBuf;
	}
	public void run(){
		synchronized (str) {
			for(int i = 0 ; i < 100 ; i++){
				System.out.println(str);
			}
		}	
			char c = str.charAt(0);
			c++;
			str.setCharAt(0,c);
	}
	
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer("A");
		SynchronizedPrint sp = new SynchronizedPrint(sb);
		Thread one = new Thread(sp);
		Thread two = new Thread(sp);
		Thread three = new Thread(sp);
		one.start();
		two.start();
		three.start();
	}
}
