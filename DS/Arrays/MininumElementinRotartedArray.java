package Arrays;

public class MininumElementinRotartedArray {

	public static int findMinimum(int[] num , int low , int end){
		if(low == end) return num[low];
		if(low<end){
			int mid = (low+end)/2;
			if(mid-1>=low&&num[mid]<num[mid-1]){
				return num[mid];
			}
			if(num[mid]<num[end])
				return findMinimum(num, low,mid-1);
			return findMinimum(num,mid+1, end);
		}
		return num[0];
	}
	public static void main(String[] args){
		int[] num = {3,4,5,6,2};
		System.out.println(MininumElementinRotartedArray.findMinimum(num,0,num.length-1));
	}
}
