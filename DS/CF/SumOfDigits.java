package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigits {

	public void compute(){
		BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			if(input.length()==1){
				System.out.println(0);
				return;
			}
			int sumOfdigits = getSumOfDigits(input);
			int count =1;
			while(sumOfdigits>9){
				count++;
				sumOfdigits = getSumOfDigits(sumOfdigits);
			}
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private int getSumOfDigits(int num) {
		int sum = 0 ;
		while(num>0){
			sum = sum + num%10;
			num = num/10;
		}
		return sum;
	}
	private int getSumOfDigits(String input) {
		int sum = 0 ;
		for(int i=0;i<input.length();i++){
			sum = sum + input.charAt(i) - '0';
		}
		return sum;
	}
	public static void main(String[] args){
		new SumOfDigits().compute();
		System.exit(0);
	}
}
