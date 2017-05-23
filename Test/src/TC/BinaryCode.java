package TC;

import java.util.Arrays;

public class BinaryCode {

	public static String[] decode(String message){
		StringBuilder sb = new StringBuilder();
		String[] res = new String[2];
		
		if(message.charAt(0) - '0'>1){
			res[0] = "NONE";
			res[1] = decodeString(1, message);
		}else{
			res[0]= decodeString(0, message);
			res[1] = decodeString(1, message);
		}
		
		return res;
	}
	
	private static String decodeString(int start,String message){
		if(message.length()==1&& message.charAt(0)-'0' >1){
			return "NONE";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(start);
		sb.append(message.charAt(0)-sb.charAt(0));
		int temp;
		for(int i = 2 ; i <message.length();i++){
    			temp = message.charAt(i-1)-sb.charAt(i-1)-sb.charAt(i-2)+'0';
			if(temp>1) return "NONE";
			sb.append(temp);
		}
		if(message.charAt(message.length()-1)!=sb.charAt(sb.length()-1)+sb.charAt(sb.length()-2)-'0')return "NONE";
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println( Arrays.toString(BinaryCode.decode("123210122")));
	}
}
