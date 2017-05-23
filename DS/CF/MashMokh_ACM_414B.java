package CF;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MashMokh_ACM_414B {

	public void compute(){
		Scanner in = null;
		try{
			in = new Scanner(new BufferedInputStream(System.in));
			int n = in.nextInt();
			int k = in.nextInt();
			long[][] dp = new long[n+1][k+1];
			for(int i=1;i<=n;i++){
				dp[i][1] = 1;
			}
			ArrayList<Integer> divisors = new ArrayList<Integer>();
			for(int j=2;j<=k;j++){
				for(int num =1;num <= n ;num++){
					 getDivisors(num , divisors);
					 for(int div : divisors){
						 dp[num][j] = dp[num][j] + dp[div][j-1];
					 }
				}
			}
			long sum = 0 ;
			for(int i=1;i<=n;i++){
				sum = sum + dp[i][k];
			}
			System.out.println(sum%1000000007);
		}finally{
			in.close();
		}
		
	}
	
	private void  getDivisors(int num, ArrayList<Integer> divisors) {
		divisors.clear();
		divisors.add(1);
		if(num==1){
			return ;
		}
		for(int i =2 ; i <=num;i++){
			if(num%i==0){
				divisors.add(i);
			}
		}
	}

	public static void main(String[] args){
		new MashMokh_ACM_414B().compute();
		System.exit(0);
	}
}
