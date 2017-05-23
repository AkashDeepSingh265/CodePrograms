package Inheritance;

import java.util.ArrayList;
import java.util.List;

public class BaseClass<T extends Number> extends SuperClass {
	
	public BaseClass(T val ){
		
	}
	public static void testStatciMethod(){
		System.out.println("inside base class static");
	}
	public void testInstanceMethod(){
		System.out.println("inside base instance method ");
	}
	public void getNumber(T num){
		System.out.println(num.byteValue());
	}
	public static void processData(List<? extends Number> num){
		System.out.println("processing data");
	}
	
	public static <V> void  exchangePositions(V ary[],int x,int y){
		V temp = ary[x];
		ary[x]= ary[y];
		ary[y]= temp;
	}
	public static void main(String[] args ){
				
		BaseClass<Integer> base = new BaseClass<Integer>(123);
		SuperClass spr = (SuperClass)base;
		spr.testInstanceMethod();
		List<Integer> lst = new ArrayList<Integer>();
		BaseClass.processData(lst);
		spr.testStatciMethod();
		base.testInstanceMethod();
		base.testStatciMethod();
		
	}
}
