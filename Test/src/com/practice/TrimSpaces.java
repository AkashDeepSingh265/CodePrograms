package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TrimSpaces {
	public boolean equals(Object abc){
		return true;
		
	}
	public static void main(String args[]){
		Object obj = new TrimSpaces();
		Object obj1 = new TrimSpaces();
		obj.equals(obj1);
		
		HashMap<Short, Integer> map = new HashMap<Short,Integer>();
		map.put((short) 123, 231);
		map.put((short) 123, 232);
		String output = "";
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String");
		String input = br.readLine();
		System.out.println("Result is ");
		

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ' && i + 1 < input.length() && input.charAt(i+1) == ' ') {
				continue;
			}
			output += input.charAt(i);
		}
		System.out.println(output);
		} catch (IOException e) {
			System.out.println(output);
			e.printStackTrace();
		}
		System.out.println("Result is ");
	}
}
