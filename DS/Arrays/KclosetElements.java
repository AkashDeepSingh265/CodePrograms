package Arrays;

public class KclosetElements {

	public static void findKClosetElements(int[] ary,int data){
		int l = findCrossOverPoint(ary,0,ary.length-1,data);
	}
	private static int findCrossOverPoint(int[] ary, int low, int high,int data) {
		if(data <=ary[low]) return low ; 
		if(data > ary[high]) return high; 
		
		int mid = low + (high - low)/2;
		if(ary[mid]==data) return mid;
		if(mid < high && ary[mid] < data && data < ary[mid+1]){
			return mid;
		}
		if(mid > low && ary[mid-1] < data && data < ary[mid]){
			return mid-1;
		}
		if(data>ary[mid]) return findCrossOverPoint(ary,mid+1, high, data);
		return findCrossOverPoint(ary,low,mid-1, data);
	}
	public static void main(String[] args){
		int	arr[] = {22,30,35, 39,42,45,48,50, 53,55};
		System.out.println(arr[KclosetElements.findCrossOverPoint(arr,0,arr.length-1,49)]);
	}
}
