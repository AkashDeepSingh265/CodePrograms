package ClassDeclerations;

//Array is object in java 
public class ArrayAsObject {

	public static void function(Long l){
		System.out.println(l.longValue());
	}
	public static void main(String[] args) {
		
		Integer i = -100;
		Integer j = -100;
		if(i==j)System.out.println("same");
		if(i!=j)System.out.println("diff");
		
		int[] num = new int[5];
		// Array is object 
		Object a = num;
		
		if(num instanceof Object){
			System.out.println("Object");
		}
		
		int[][] ary = {{1,1},{2,2},{3,3}};
		int[] numb = ary[0];
		if(ary[0]==numb){
			System.out.println("Same Array reference");
		}
	}

}
