package package3;

import package2.subclass;

public class Subclass extends subclass {

	public void print(){
		System.out.println(x);
	}
	public native void  printLine();
	public static void main(String[] args){
		new Subclass().print();
	}
}
