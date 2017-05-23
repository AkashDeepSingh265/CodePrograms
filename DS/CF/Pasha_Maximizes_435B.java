package CF;

import java.util.Scanner;

public class Pasha_Maximizes_435B {

	public void compute(){
		Scanner in = null;
		try{
			in = new Scanner(System.in);
			String input = in.nextLine();
			String number = input.split(" ")[0];
			int swaps = Integer.parseInt(input.split(" ")[1]);
			if(swaps==0||number.length()==1){
				System.out.println(number);
				return;
			}
			int i = 0 ;
			int maxInd = -1;
			do{
				maxInd = findMaximumNumberIndex(number,i+1,i+swaps>number.length()-1? number.length()-i-1 :swaps);
				if(number.charAt(maxInd)>number.charAt(i)){
					number = swapDigits(number,i,maxInd);
					swaps = swaps-(maxInd-i);
				}
				i++;
			}while(i<number.length()-1&&swaps>0);
			System.out.println(number);
		}finally{
			in.close();
		}
		
	}
	private String swapDigits(String number, int startInd, int lastIndex) {
		char[] num = number.toCharArray();
		char temp;
		for(int i =lastIndex;i > startInd ; i--){
			temp=num[i];
			num[i]=num[i-1];
			num[i-1]=temp;
		}
		return String.valueOf(num);
	}
	//lenght including offset
	private int findMaximumNumberIndex(String input , int offset , int length ){
		
		int max = -1 ;
		int index=-1;
		for(int i = offset;i<offset+length;i++){
			if(Character.getNumericValue(input.charAt(i)) > max){
				max = Character.getNumericValue(input.charAt(i));
				index = i;
			}
		}
		return index ;
	}
	public static void main(String[] args){
		new Pasha_Maximizes_435B().compute();
	}
}
