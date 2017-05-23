package Sorting;

import java.util.Arrays;

public class ClosetTOZero3Numbers {

	private void findNumbers(int[] ary){
		int left = 0;
		int right = ary.length -1;
		Arrays.sort(ary);
		int positivesum = Integer.MAX_VALUE;
		int pos1=-1,pos2=-1,pos3=-1;
		int temp;
		while(left<right-1){
			temp = ary[left]+ary[left+1]+ary[right];
			if(temp==0){
				pos1=left;pos2=left+1;pos3=right;
				break;
			}
			if(Math.abs(temp)<positivesum){
				pos1=left;pos2=left+1;pos3=right;
			}
			if(temp>0){
				right--;
			}else {
				left++;
			}
		}
		System.out.println("Numbers are : "+ary[pos1]+","+ary[pos2]+","+ary[pos3]);
	}
	
	public static void main(String[] args){
		int arr[] = { -45,  55,  9, -99, 100, 21, -29};
		new ClosetTOZero3Numbers().findNumbers(arr);
	}
	
}
