package ICPC;

import java.util.Scanner;

public class NumberSum {
	private int totalSum=0;
	public static void main(String[] args){
		new NumberSum().compute();
	}

	private void compute() {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		String baseValue=null;
		for(int i=2;i<=num-1;i++){
			 convertToBase(num,i);
		}
		int divisor = num-2;
		int gcd = findGcd(totalSum,divisor);
		totalSum=totalSum/gcd;
		divisor=divisor/gcd;
		System.out.println(totalSum+"/"+divisor);
	}
	
	private int findGcd(int number1, int number2) {
		if(number2 == 0){
            return number1;
        }
        return findGcd(number2, number1%number2);
	}

	private int getDigitSum(int parseInt) {
		int sum=0;
		do{
			sum=sum+parseInt%10;
			parseInt = parseInt/10;
		}while(parseInt>0);
		return sum;
	}

	public void convertToBase(int num , int base){
		do{
			totalSum = totalSum + num%base ;
			num = num /base;
		}while(num>0);
		
	}
}
