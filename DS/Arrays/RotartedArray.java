package Arrays;

public class RotartedArray {
	//below cases can be formed with this example {2,1} . mid can be either 2 or 1 .
	public static int oneScanSearch(int[] numbers , int low , int high,int data){
		if(high < low) return -1;
		//if(high == low) return low;
		int mid = low + (high-low)/2;
		if(numbers[mid]==data)return mid;
		if(data>=numbers[0]){
			if(numbers[mid]>=numbers[0]&&data>numbers[mid]){
				return oneScanSearch(numbers,mid+1, high, data);
			}else{
				return oneScanSearch(numbers, low,mid-1, data);
			}
		}else{
			if(numbers[mid]<=numbers[numbers.length-1]&&data<numbers[mid]){
				return oneScanSearch(numbers, low,mid-1, data);
			}else{
				return oneScanSearch(numbers,mid+1, high, data);
			}
		}
	}
	
	public static int findPivot(int[] numbers , int low , int high ){
		if(high < low) return -1;
		if(high == low ) return low;
		int mid = low + (high-low)/2;
		if (mid < high && numbers[mid] > numbers[mid + 1]){
			System.out.println("low: "+low+" high : "+high+" mid:"+mid);
		     return mid;
		}    
		if (mid > low && numbers[mid] < numbers[mid - 1]){
			System.out.println("low: "+low+" high : "+high+" mid:"+mid);
			return (mid-1);
		}
		     
		if (numbers[low] >= numbers[mid])
		    return findPivot(numbers, low, mid-1);
		else
		   return findPivot(numbers, mid + 1, high);
	}
	public static void main(String[] args){
		int[] numbers = {  26,30,35,37,45,  98,1,3,4,6,  8,10,13,15,16, 19,20,25};
		//System.out.println(numbers[RotartedArray.findPivot(numbers,0,numbers.length)]);
		int search;
		for(int i = 0 ;i < 100 ; i++){
			search = (int) (100*Math.random()%numbers.length);
			System.out.print(numbers[search]+":");
			System.out.println(RotartedArray.oneScanSearch(numbers,0,numbers.length-1,numbers[search]));
		}
		System.out.println();
	}
}
