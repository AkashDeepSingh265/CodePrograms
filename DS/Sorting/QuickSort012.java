package Sorting;

import java.util.Arrays;

public class QuickSort012 {

	
	private void input(){
		int[] numbers={0,0,1,1,1,1,2,2,2,2,2,2};
		quickSort(numbers,0,numbers.length-1);
		System.out.println(Arrays.toString(numbers));
	} 
	
	private void quickSort(int[] numbers, int start, int end) {
		int pivot;
		if(start< end){
			pivot = getPivot(numbers,start,end);
			if(pivot==-1)return;
			quickSort(numbers, start,pivot-1);
			quickSort(numbers,pivot+1, end);
		}
	}

	private int getPivot(int[] numbers, int start, int end) {
		int pivotIndex=-1 ,temp;
		for(int i=start;i<=end;i++){
			if(numbers[i]==1){
				pivotIndex=i;break;
			}
		}
		if(pivotIndex==-1)return -1;
		int left = start;
		int right = end;
		
		left = start;
		right = end;
		while(left<right){
			while((left < end) && (numbers[left] <=
					numbers[pivotIndex])){
				left++;
			}
			while(numbers[right]>numbers[pivotIndex]){
				right--;
			}
			if(left < right){
				temp = numbers[left];
				numbers[left]=numbers[right];
				numbers[right]= temp;
			}
		}
		temp=numbers[pivotIndex];
		numbers[pivotIndex] = numbers[right];
		numbers[right]=temp;
		return right;
	}

	public static void main(String[] args){
		new QuickSort012().input();
	}
}
