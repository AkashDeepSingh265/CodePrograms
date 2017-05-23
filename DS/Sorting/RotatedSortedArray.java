package Sorting;

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
					if(number>=ary[0])  return binarySearchRotated(ary,start,mid-1, number);
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
	public static void main(String[] args){
		int[] numbers = {15,16,19,20,25,26,30,35,37,45,98,1,3,4,6,8,10,13};
		int search;
		System.out.println(new RotatedSortedArray().findPivot(numbers,0,numbers.length));
//		for(int i = 0 ;i < 100 ; i++){
//			search = (int) (100*Math.random()%numbers.length);
//			System.out.print(numbers[search]+":");
//			System.out.println(new RotatedSortedArray().binarySearchRotated(numbers,0,numbers.length-1,numbers[search]));
//		}
		
	}
}
