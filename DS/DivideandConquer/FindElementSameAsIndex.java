package DivideandConquer;

public class FindElementSameAsIndex {

	private int findIndexBinary(int[] ary,int start,int end){
		int mid;
		if(start<=end){
			mid = start + (end-start)/2;
			if(ary[mid]==mid)return mid;
			
			if(ary[mid]>mid){
				return findIndexBinary(ary, start,mid-1);
			}else{
				return findIndexBinary(ary,mid+1,end);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] numbers={-1,-3,-1,0,3,4,5,8,9,10};
		int index = new FindElementSameAsIndex().findIndexBinary(numbers,1,numbers.length-1);
		System.out.println(index);
	}

}
