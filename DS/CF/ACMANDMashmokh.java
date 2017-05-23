package CF;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ACMANDMashmokh {

	public void compute(){
		Scanner in = null;
		
		try{
			in = new Scanner(new BufferedInputStream(System.in));
			int n = in.nextInt();
			int m = in.nextInt();
			int[] dp = new int[n+1];
			Arrays.fill(dp,1);
			for (int i = 0; i < m - 1; i++) {
	            for (int j = n; j >= 1; j--) {
	                for (int k = 2 * j; k <= n; k += j) {
	                    dp[k] = getModulo(dp[k], dp[j]);
	                }
	            }
	        }
			int sum = 0 ;
			for(int i=1;i<=n;i++){
				sum = getModulo(sum , dp[i]);
			}
			System.out.println(sum);
		}finally{
			in.close();
		}
		
	}
	
	private int getModulo(int l, int m) {
		if(l+m>=1000000007) return l+m - 1000000007;
		return l+m;
	}

	public static void main(String[] args){
		new ACMANDMashmokh().compute();
		System.exit(0);
	}
}
