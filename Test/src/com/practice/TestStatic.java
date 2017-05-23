package com.practice;

import java.util.ArrayList;
import java.util.List;

 class staticsuperClass {
	public static int noofCopies=0;
	 int abc=0; 
	public staticsuperClass(){
		noofCopies++;
		//System.out.println("created new copy id "+noofCopies);
	}
	public static void statmethod(){
		System.out.println("Supeclass");
	}
	public int getABC(){
		return abc;
	}
	
}

 public class TestStatic extends staticsuperClass{
	 int abc = 1;
	 public static void statmethod(){
			System.out.println("Baseclass");
	}
	 public int getABC(){
			return abc;
	}
	 
	 public static void main(String[] args){
			staticsuperClass ts = new TestStatic();
			ts.statmethod();
			System.out.println(ts.getABC());
			//System.out.println(ts.abc);
			
			TestStatic ts1 = new TestStatic();
			ts1.statmethod();
			System.out.println(ts1.getABC());
			System.out.println(Integer.toBinaryString(-127));
			//System.out.println(ts1.abc);
			
	 }
 }