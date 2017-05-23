package Generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardsTest {

	//Wild cards are read only.we cannot add element to lst
	public void displayList(List<? extends Number> lst){
		
		for(Number n : lst){
			System.out.println(n.byteValue());
		}
	}
	
	public void displayListW(List<?> lst){
		Byte b = (Byte)lst.get(0);
	}
	public static void main(String[] args){
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		List<Byte> byteList = new ArrayList<Byte>();
		byteList.add((byte) 1);
		byteList.add((byte) 2);
		new WildCardsTest().displayListW(byteList);
		new WildCardsTest().displayList(byteList);
	}
}
