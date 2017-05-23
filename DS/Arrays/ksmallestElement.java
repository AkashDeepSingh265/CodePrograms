package Arrays;

import java.util.Arrays;
import java.util.Random;

//1. we can sort and return a[k-1];
//2. we can use min heap and extract k times . n + klogn
//3. we can use similar to quick sort .
public class ksmallestElement {
	public static int findKSmallElement(int[] arr,int l , int r,int k){
		//System.out.println(l+" " + r + " " +k);
		int pos = randomPartition(arr,l,r);
		//System.out.println("pos :"+pos);
		if(pos == k-1)return arr[l+pos];
		if(k-1<pos){
			return findKSmallElement(arr,l,l+pos-1,k);
		}else{
			return findKSmallElement(arr,l+pos+1,r,k-pos);
		}
	}
	
	private static int randomPartition(int[] arr, int l, int r) {
		int rand = new Random().nextInt(r-l+1)+l ;
		swap(arr,rand,r);
		return partition(arr,l,r);
	}

	private static int partition(int[] arr, int l, int r) {
		int pivot = arr[r];
		int left = l ; 
		int right = r;
		while(left<right){
			while(left<r&&arr[left]<pivot)left++;
			while(right>l&&arr[right]>=pivot)right--;
			if(left<right) swap(arr,left,right);
		}
		swap(arr,left,r);
		return left-l;
	}

	private static void swap(int[] arr, int left, int right) {
		arr[left] = arr[left]^arr[right];
		arr[right] = arr[left]^arr[right];
		arr[left] = arr[left]^arr[right];
	}

	public static void main(String[] args){
		//int[] arr = GenerateRandomArray.generateArray(15);
		int[] arr = {1,7,15,5,8,3,10,2,4};
		System.out.println(Arrays.toString(arr));
		System.out.println(ksmallestElement.findKSmallElement(arr,0,arr.length-1,5));
	}
}
