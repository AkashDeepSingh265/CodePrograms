package com.learning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SomeIterator {
	public static void main(String[] args){
		List<String> nameList = new ArrayList<String>();
		nameList.add("Akash deep");
		nameList.add("Bhola");
		nameList.add("Kobra");
		Iterator<String> it = nameList.iterator();
		//by using iterator we can remove elements 
		while(it.hasNext()){
			System.out.println(it.next());
			it.remove();
		}
		//here we get exception if we remove element
		for(String name : nameList){
			nameList.remove(name);
		}
	}
}
