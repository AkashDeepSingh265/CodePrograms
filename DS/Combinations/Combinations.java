package Combinations;

public class Combinations {

	public static void generateCombinations(int[] array,int r,int[] temp,int size,int curPos){
		if(size==r){
			for(int i = 0 ; i < r ; i ++){
				System.out.print(temp[i]+",");
			}
			System.out.println();
			return;
		}
		if(curPos >= array.length)
			return;
		generateCombinations(array, r, temp, size, curPos+1);
		temp[size++] = array[curPos];
		generateCombinations(array, r, temp, size, curPos+1);
	}
	
	public static void main(String[] args){
		int[] array = {2,8,14,6,7};
		int r = 2;
		int[] temp = new int[r];
		generateCombinations(array, r, temp, 0, 0);
	}
}
