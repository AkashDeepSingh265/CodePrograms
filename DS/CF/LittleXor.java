package CF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class LittleXor {

	public void compute(){
		Scanner in = null;
		try{
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int n = in.nextInt();
			int[] ary= new int[n];
			for(int i=0;i < n;i++){
				ary[i] = in.nextInt();
			}
			Arrays.sort(ary);
			int maxXor = ary[n-1];
			int temp;
			for(int i=n-1;i-1>=0;i--){
				temp = maxXor^ary[i-1];
				if(temp>maxXor){
					maxXor=temp;
				}
			}
			System.out.println(maxXor);
		}finally{
			in.close();
		}
	}
	public static void main(String[] args){
		new LittleXor().compute();
		System.exit(0);
	}
}
