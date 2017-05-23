package Strings;

import java.util.Arrays;

public class Permutations {

	private void generatePeramutations(int depth,int[] used,char[] permutations,char[] original){
		if(depth==original.length){
			System.out.println(Arrays.toString(permutations));
		}else{
			for(int i=0;i<original.length;i++){
				if(used[i]!=1){
					used[i]=1;
					permutations[depth]=original[i];
					generatePeramutations(depth+1, used, permutations, original);
					used[i]=0;
				}
			}
		}
	}
	public static void main(String[] args){
		String str = "BCA";
		char[] pemutations = new char[4];
		int[] used = {0,0,0,0,0};
		char[] original = str.toCharArray();
		Arrays.sort(original);
		new Permutations().generatePeramutations(0, used, pemutations,original );
	}
}
