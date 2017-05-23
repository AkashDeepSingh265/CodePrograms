package com.practice;

public class Singletonclass {
	private static Singletonclass _ref ;
	private static int noOfCopies;
	private int id=  initializeInt();
	private Singletonclass(){
		
	}
	private final int initializeInt() {
		// TODO Auto-generated method stub
		return 0;
	}
	static{
		int a=5*123;
		noOfCopies=a;
	}
	
	public static Singletonclass getInstance(){
		if(_ref==null){
			_ref = new Singletonclass();
			_ref.id=123;
		}
		return _ref;
	}
	
	public static void main(String[] args){
		Singletonclass a = Singletonclass.getInstance();
		Singletonclass b = Singletonclass.getInstance();
		System.out.println(Singletonclass.noOfCopies);
	}
}
