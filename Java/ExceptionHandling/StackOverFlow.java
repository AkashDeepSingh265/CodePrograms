package ExceptionHandling;

import java.util.Collections;
import java.util.Hashtable;

public class StackOverFlow {

	private static int count = 0 ;
	
	private static void recursive(){
		try{
			count++;
			recursive();
		}catch(StackOverflowError e){
			System.out.println(count);
			System.out.println("Free JVM Memory After Exit:"+Runtime.getRuntime().freeMemory());
			//e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		
		try{
		StackOverFlow.recursive();
	}catch(StackOverflowError e){
		//System.out.println(count);
		//System.out.println("Free JVM Memory :"+Runtime.getRuntime().freeMemory());
		//e.printStackTrace();
	}
	}
}
