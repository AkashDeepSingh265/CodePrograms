package Assignments;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Here we need to explicitly cast as integer literals are by default int . 
class Alien {
	String invade(short ships){
		return "a few";
	}
	
	String invade(short... ships){
		return "many";
	}
}

public class TestCasting {
	public static void main(String[] args){
		short s = 7;
		int[][] a = {{1,2},{3,4}};
		int[] b = a[1];
		Object o = a;
		int[][] a2 = (int[][]) o;
		int[] b2 = (int[]) o;
		//compile error
		//System.out.println(new Alien().invade(7));
	}
}

