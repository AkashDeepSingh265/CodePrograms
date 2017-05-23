package Programs;

import java.util.Arrays;

public class FindNextgreaterNumber {

	public static String nextGreaterNumber(String number){
		char[] num = number.toCharArray();
		int i = num.length-1;
		while(i>=1&&num[i]<=num[i-1]){
			i--;
		}	
		if(i==0)return "Not Possible";
		num[i-1]=(char) (num[i-1]^num[num.length-1]);
		num[num.length-1] =  (char) (num[i-1]^num[num.length-1]);
		num[i-1]=(char) (num[i-1]^num[num.length-1]);
		
		Arrays.sort(num,i,num.length);
		return Arrays.toString(num);
	}
	public static void main(String[] args){
		System.out.println(FindNextgreaterNumber.nextGreaterNumber("12345"));
	}
}
