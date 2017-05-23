package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static int getLis(int[] array){
		int[] lis = new int[array.length];
		for(int i = 0 ; i < array.length;i++){
			lis[i]=1;
		}
		for(int i = 1 ; i < array.length;i++){
			for(int j = i ; j>=0;j--){
				if(array[j]<array[i]&&lis[i]<lis[j]+1){
					lis[i] = lis[j]+1;
				}
			}
		}
		System.out.println(Arrays.toString(lis));
		int max = 0 ;
		for(int i = 0 ; i < lis.length;i++){
			if(lis[i]>max){
				max = lis[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 , 35};
		System.out.println(LongestIncreasingSubsequence.getLis(arr));
	}
}
