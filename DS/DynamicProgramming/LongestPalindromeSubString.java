package DynamicProgramming;

public class LongestPalindromeSubString {

	public static  void findLongestPalindrome(String s){
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int maxLentgh = -1;
		int maxX = -1;
		int maxY = -1;
		for(int i = 0 ; i < n ; i ++){
			dp[i][i] = true;
		}
		for(int end = 0 ; end <n;end++){
			for(int start = 0 ; start <=end;start++){
					if(start +1 <= end-1){
						if(dp[start+1][end-1] && (s.charAt(start)==s.charAt(end))){
						dp[start][end] = true;
						if(end-start+1>maxLentgh){
							maxLentgh = end - start +1;
							maxX = start;
							maxY = end;
						}
					}
				}else{
					//length == 2
					if(start+1==end){
						if(s.charAt(start)==s.charAt(end)){
							dp[start][end]=true;
							if(end-start+1>maxLentgh){
								maxLentgh = end - start +1;
								maxX = start;
								maxY = end;
							}
						}
					}
				}
			}
		}
		System.out.println(s.substring(maxX, maxY+1));
	}
	
	public static void main(String[] args){
		String s = "ashisih";
		LongestPalindromeSubString.findLongestPalindrome(s);
	}
}
