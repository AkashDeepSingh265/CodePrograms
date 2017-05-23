package DynamicProgramming;

public class SubSetSum {

	public static boolean isSubset(int[] array,int sum){
		boolean[][] dp = new boolean[sum+1][array.length+1];
		
		for(int i = 0 ; i <=array.length;i++){
			dp[0][i]= true;
		}
		for(int i = 1;i<=sum;i++){
			dp[i][0] = false;
		}
		
		for(int i = 1 ; i <=sum;i++){
			for(int j = 1 ; j <= array.length;j++){
				dp[i][j]=dp[i][j-1];
				if(i>=array[j-1]){
					dp[i][j] = dp[i][j] || dp[i-array[j-1]][j-1];
				}
			}
		}
		return dp[sum][array.length];
	}
	public static void main(String[] args){
		int[] ary = {3,34,4,12,5,2};
		System.out.println(SubSetSum.isSubset(ary,14));
	}
}
