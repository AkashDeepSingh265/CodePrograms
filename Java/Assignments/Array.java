package Assignments;
//Array elemets are always given the default values regardless of where the array is 
// initialized (Local variable or instance variable ) . both array and ary get zero as default 
// values for their elements 
public class Array {

	private int[] ary = new int[10];
	
	private void method(){
		int[] array = new int[10] ;
		System.out.println(array[1]);
	}
	public static void main(String[] args){
		new Array().method();
		Integer[] ary = new Integer[10];
		Number[] num = ary;
		num[0] = 3;
		num[1]= new Double(123.44);
	}
}
