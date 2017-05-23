package CF;

import java.util.Arrays;

public class MergeSort {
	
	private int[] array;
	private int[] helper;
	private void mergeSort(int start , int end){
		if(start < end){
			int mid = (start+end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			merge(start,mid,end);
		}
	}
	
	private void merge(int start, int mid, int end) {
		for(int i=start;i<=end;i++){
			helper[i] = array[i];
		}
		int i = start;              
		int j = mid+1;
		int k=start;
		
		while(i<=mid&&j<=end){
			if(helper[i]<helper[j]){
				array[k]=helper[i];
				i++;
			}else{
				array[k]=helper[j];
				j++;
			}
			k++;
		}                                           
		while(i<=mid){
			array[k]=helper[i];
			i++;k++;
		}
		
	}

	public void sort(int[] ary ){
		int length = ary.length;
		this.array = ary;
		this.helper = new int[length];
		mergeSort(0,length-1);
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args){
		int[] input = {10,20,14,50,3,8,90,75,8,11,34,5,4,7,8,33,22,44,55,66,18,28,34,52};
		new MergeSort().sort(input);
	}
}
