package Generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class CreateGenericArrayList {

	public <T> void makeArrayList(T t){
		List<T> list = new ArrayList<T>();
		list.add(t);
	}
	
	public static void main(String[] args){
		CreateGenericArrayList obj = new CreateGenericArrayList();
		PriorityQueue<String> queue = new PriorityQueue<>();
		
		obj.makeArrayList(123);
	}
}
