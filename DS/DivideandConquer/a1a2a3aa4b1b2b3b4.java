package DivideandConquer;

import java.util.Arrays;

//this class arranges elements only if n=2poweri
public class a1a2a3aa4b1b2b3b4 {

	private void recursiveArrange(int[] numbers,int start,int end){
		if(start+1==end)return;
		int mid = start+ (end-start)/2;
		int k = mid;
		int mid2 = start + (mid-start)/2;
		k++;mid2++;
		int temp;
		while(mid2<=mid){
			temp = numbers[mid2];
			numbers[mid2]=numbers[k];
			numbers[k]=temp;
			k++;mid2++;
		}		
		recursiveArrange(numbers, start,mid);
		recursiveArrange(numbers,mid+1, end);
	}
	
	private void arrange(int[] numbers){
		recursiveArrange(numbers,0,numbers.length-1);
	}
	public static void main(String[] args){
		int[] numbers = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31 ,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32};
		new a1a2a3aa4b1b2b3b4().arrange(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
