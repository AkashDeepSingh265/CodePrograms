package Mathematics;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class FactorialLargeNumber {

	public static void factorial(int n){
		int[] res = new int[11000000];
		res[0]=1;
		int res_size=1;
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		for(int i = 2; i <=n;i++){
			res_size  = multiply(res,i, res_size);
		}
		
		for(int i = res_size-1; i >=0;i--){
			out.print(res[i]);
		}
		out.flush();
		out.close();
	}
	//res array is in reverse order 123 is stored as {3,2,1}
	public static int multiply(int[] res,int n , int res_size){
		int carry = 0 ;
		int prod;
		for(int i = 0 ; i < res_size;i++){
			prod = res[i]*n + carry;
			res[i] = prod%10;
			carry = prod/10;
		}
		while(carry>0){
			res[res_size] = carry%10;
			carry = carry /10;
			res_size ++;
		}
		return res_size;
	}
	public static void main(String[] args){
		FactorialLargeNumber.factorial(3350);
	}
}
