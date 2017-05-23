package Programs;

public class ArrayBig {

	public static void main(String[] args){
		System.out.println(Runtime.getRuntime().freeMemory());
		int q = Integer.MAX_VALUE;
		int[] bigAry = new int[q];
		System.out.println(Runtime.getRuntime().freeMemory());
		
	}
}
