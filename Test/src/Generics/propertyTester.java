package Generics;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;


interface Property<T>{
	public boolean test(T elem);
}

class evenProperty implements Property<Integer>{

	@Override
	public boolean test(Integer elem) {
		return elem%2 == 0;
	}
}

class palindromeProperty implements Property<String>{
	@Override
	public boolean test(String elem) {
		return elem.charAt(0)==elem.charAt(elem.length());
	}
	
}

public class propertyTester{
	
	public static <T> int count(Collection<T> c,Property<T> p){
		return 0;
	}

	public static void main(String[] args){
		int[] A ;
	
		try {
			//PrintWriter prt = new PrintWriter("abc.txt");
			//prt.println();
			
		}
		catch(NumberFormatException e){
			
		}
		catch(Exception e){
			
		}
		finally{
			System.out.println("exiting program");
		}
		
		
	}
}