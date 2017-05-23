package com.practice;

import java.util.ArrayList;

class Parameters {
	private int a;
	private int b;
	
	public static void print(Object... strings ) {
		for(int i=0;i<strings.length;i++){
			System.out.print(strings[i].toString());
		}
	}
	
	public static void arraylst(ArrayList<String> lst){
		lst.add("bc swaad ");
	}
	
	public static void main(String[] args) {
		System.out.println(TestStatic.noofCopies);
		String[] abc={"abc","  ","swert"};
		Parameters.print(abc);
		ArrayList<String> lst = new ArrayList<String>();
		Parameters.arraylst(lst);
		System.out.println(lst.size());
	}

}
