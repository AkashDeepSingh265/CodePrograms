package Sorting;

import java.util.Arrays;

public class Sorting012DutchFlag {

	private void sort(int[] numbers,int n){
		int curPos=0,pos0=0,pos2=n-1;
		while(curPos<=pos2){
			if(numbers[curPos]==0){
				numbers[curPos]=numbers[pos0];
				numbers[pos0]=0;
				pos0++;
			}if(numbers[curPos]==2){
				numbers[curPos]=numbers[pos2];
				numbers[pos2]=2;
				pos2--;
				curPos--;
			}
			curPos++;
		}
		
	}
	public static void main(String[] args) {
		int[] numbers = {0,1,1,0,1,2,1,2,0,0,0,1};
		new Sorting012DutchFlag().sort(numbers,numbers.length);
		System.out.println(Arrays.toString(numbers));
	}

}
