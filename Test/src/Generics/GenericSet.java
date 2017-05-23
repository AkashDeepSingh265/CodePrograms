package Generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericSet<T> {
	private T[] ary;
	
	public GenericSet(Class<T> clas){
	ary = (T[]) Array.newInstance(clas,10);
	}
	
	public static void main(String [] args){
		new GenericSet<String>(String.class);//.class return the class object of the String
	}
}
