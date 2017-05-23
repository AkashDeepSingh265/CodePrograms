package Arrays;

import java.util.Random;

public class GenerateRandomArray {

	public static int[] generateArray(int size){
		int[] arr = new int[size];
		Random r = new Random();
		for(int i = 0 ; i < size ; i++){
			arr[i] =  r.nextInt(size)+1;
		}
		return arr;
	}
}
