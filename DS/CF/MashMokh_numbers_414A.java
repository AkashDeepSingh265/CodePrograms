package CF;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MashMokh_numbers_414A {
	
	public void compute(){
		Scanner in = null;
		try{
			in = new Scanner(new BufferedInputStream(System.in));
			int n = in.nextInt();
			int k = in.nextInt();
			if(k==0&&n==1){
				System.out.println(1);
				return;
			}
			if(k<n/2||n/2<1){
				System.out.println(-1);
				return;
			}
			
			int x = k-(n/2-1);
			int[] res =new int[n];
			res[0]=x;
			res[1]=2*x;
			int j = 2;
			for(int m = n/2-1;m>0;m--,j++){
				res[j] = res[j-1]+1;
				j++;
				res[j] = res[j-1]+1;
			}
			if(n%2==1){
				res[j]=res[j-1]+1;
			}
			System.out.println(Arrays.toString(res).replace("[","").replace(",","").replace("]",""));
		}finally{
			in.close();
		}
	}
	
	public static void main(String[] args){
		new MashMokh_numbers_414A().compute();
		System.exit(0);
	}
}
