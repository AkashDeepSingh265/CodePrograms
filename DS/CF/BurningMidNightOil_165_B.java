package CF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BurningMidNightOil_165_B {

	public void compute(){
		Scanner in = null;
		try{
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int n = in.nextInt();
			int k = in.nextInt();
			int sum=0;
			int power ;
			for(int i = 0;;i++){
				if((int)(n/Math.pow(k,i))==0){
					power = i;
					break;
				}
				sum = sum + (int)Math.pow(k,i);
			}
			System.out.println((int)Math.ceil((n*Math.pow(k,power-1))/sum));
		}finally{
			in.close();
		}
	}
	public static void main(String[] args){
		new BurningMidNightOil_165_B().compute();
		System.exit(0);
		
	}
}
