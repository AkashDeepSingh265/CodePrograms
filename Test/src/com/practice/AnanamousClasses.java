package com.practice;


public class AnanamousClasses {
	private int xyz=123;
	public void sayhello(){
		final int xyz=456;
		
		class MyHelloTest implements HelloTest{

			@Override
			public void printString() {
				System.out.println("Akash Deep Singh");		
			}

			@Override
			public void printInt() {
				System.out.println(xyz);
				
			}
			
		}
		
		
		HelloTest mht = new MyHelloTest();
		HelloTest mht1 = new HelloTest() {
			
			@Override
			public void printString() {
				System.out.println("Akash Deep Singh 1");
			}
			
			@Override
			public void printInt() {
				System.out.println(xyz);
			}
		};
		mht.printInt();
		mht.printString();
		mht1.printInt();
		mht1.printString();
	}
	public static void main(String[] args){
		new AnanamousClasses().sayhello();
	}
	 
}
