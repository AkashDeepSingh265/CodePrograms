package Arrays;

//Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. Elements should be removed either end of the array.
//
//Number of removals should be minimum.
//
//Examples:
//
//arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
//Output: 4
//We need to remove 4 elements (4, 5, 100, 200)
//so that 2*min becomes more than max.


public class TrimArrays2MinGreaterThanMax {

	public static int findMinimunElementsDp(int[] num){
		int n = num.length,min,max;
		int[][] dp = new int[n][n];
		for(int gap = 1 ; gap < n;gap++){
			for(int i = 0 , j = gap ; j<n;i++,j++ ){
				min = findMin(num,i,j);
				max = findMax(num,i,j);
				dp[i][j] = (2*min > max) ? 0 : Math.min(dp[i][j-1]+1 , dp[i+1][j]+1);
			}
		}
		return dp[0][n-1];
	}
	private static int findMin(int[] arr, int l, int h) {
		int mn = arr[l];
	    for (int i=l+1; i<=h; i++)
	       if (mn > arr[i])
	         mn = arr[i];
	    return mn;
	}
	private static int findMax(int[] arr, int l, int h) {
		int mx = arr[l];
	    for (int i=l+1; i<=h; i++)
	       if (mx < arr[i])
	         mx = arr[i];
	    return mx;
	}
	public static void main(String[] args){
		int[] num = {4, 5, 100, 9, 10, 11, 12, 15, 200};
		System.out.println(TrimArrays2MinGreaterThanMax.findMinimunElementsDp(num));
	}
}
