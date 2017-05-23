package Streams;

import java.util.Scanner;

public class StreamToString {

	public static void main(String[] args){
		System.out.println("abc");
		
		Scanner in = null;
		try{
			in = new Scanner(System.in).useDelimiter("\\A");
			String s = in.next();
			System.out.println(s);
		}finally{
			in.close();
		}
		
	}
}
