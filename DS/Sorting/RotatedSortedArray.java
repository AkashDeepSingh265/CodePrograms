package Sorting;

import java.util.Arrays;

public class RotatedSortedArray {
	
	private int findPivot(int[] ary , int start , int end){
		int mid;
		if(start == end) return start;
		else {
			if(start == end-1){
				if(ary[start]>=ary[end])
					return start;
				else return end;
			}
			else {
				mid = start + (end-start)/2;
				if(ary[start]>=ary[mid])
					return findPivot(ary, start,mid);
				else return findPivot(ary,mid, end);
			}
		}
	}
	
	private int binarySearchRotated(int[] ary , int start,int end,int number){
		int mid;
		if(start<=end){
			mid = start + (end-start)/2;
			if(ary[mid] == number)return mid;
			//if(number==ary[0])return 0;
			if(ary[mid]>=ary[0]){
				if(number < ary[mid]){
					if(number>=ary[0])
						return binarySearchRotated(ary,start,mid-1, number);
					else  return binarySearchRotated(ary,mid+1, end, number);
				}else{
					return binarySearchRotated(ary,mid+1,end, number);
				}
			}else{
				if(number<ary[mid]){
					 return binarySearchRotated(ary, start,mid-1, number);
				}else{
					if(number < ary[0]) return binarySearchRotated(ary,mid+1, end, number);
					else return binarySearchRotated(ary,start,mid-1, number);
				}
			}
		}
		return -1;
	}
	private void reverseArray(int[] ary,int currnt,int size,int[] pos){
		int currentVal = ary[currnt];
		//System.out.println(currnt);
		if(currnt<size-1)
			reverseArray(ary, ++currnt, size, pos);
		ary[pos[0]++]=currentVal;
	}
	
	private int binarySearchRotatedNew(int[] ary , int start,int end,int number){
		int mid;
		if(start<=end){
			mid = (start+end)/2;
			if(ary[mid] == number)return mid;
			
			if(ary[mid]>=ary[start]){
				if(ary[start] <= number && number < ary[mid])
					return binarySearchRotated(ary,start,mid-1, number);
					else  
						return binarySearchRotated(ary,mid+1, end, number);
				
			}else{
				if(number > ary[mid] && number < ary[end])
					 return binarySearchRotated(ary, mid+1,end, number);
				else
					 return binarySearchRotated(ary,start,mid-1, number);
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] numbers = {15,16,19,20,25,26,30,35,37,45,98,1,3,4,6,8,10,13};
		//int search;
		RotatedSortedArray obj = new RotatedSortedArray();
		int[] pos = {0};
		obj.reverseArray(numbers, 0, numbers.length,pos);
		System.out.println(Arrays.toString(numbers));
		//System.out.println(new RotatedSortedArray().findPivot(numbers,0,numbers.length));
//		for(int i = 0 ;i < 10 ; i++){
//			search = (int) (100*Math.random()%numbers.length);
//			System.out.println(numbers[search]+":");
//			System.out.println("old"+new RotatedSortedArray().binarySearchRotated(numbers,0,numbers.length-1,numbers[search]));
//			System.out.println("new"+new RotatedSortedArray().binarySearchRotatedNew(numbers,0,numbers.length-1,numbers[search]));
//		}
		
	}
}
