package Arrays;

//Smallest subarray with sum greater than a given value
//{1, 4, 46, 6, 0, 19}
//x  =  51
//Output: 3
//Minimum length subarray is {4, 45, 6}
public class subarraysumgreater {

	public static int subArrayLength(int[] ary,int x){
		int cur_sum = 0;
		int minLength=Integer.MAX_VALUE;
		int start=0,end=0;
		
		while(end<ary.length){
			while(end<ary.length&&cur_sum<=x){
				cur_sum += ary[end];
				end++;
			}
			
			while(cur_sum>x&&start<end){
				if(end-start<minLength){
					minLength = end - start;
				}
				cur_sum -= ary[start++];
			}
			
		}
		return minLength;
	}
	public static void main(String[] args){
		int[] num = {1,4,46,6,0,19};
		int x = 51;
		System.out.println(subarraysumgreater.subArrayLength(num, x));
	}
}
