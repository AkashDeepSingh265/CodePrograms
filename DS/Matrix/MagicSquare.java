package Matrix;

import java.util.Arrays;

public class MagicSquare {
	private int[][] magicsquare;
	private void generateMagicsquare(int n){
		magicsquare = new int[n][n];
		int curROw = (n-1)/2;
		int curCOl = n-1;
		magicsquare[curROw][curCOl] = 1;
		int row , col ;
		for(int i = 2 ;i<=n*n;i++){
			row = curROw -1;
			if(row>n-1)row = 0;
			if(row <0)row = n-1;
			col = curCOl +1;
			if(col>n-1)col = 0;
			if(col<0) col = n-1;
			if(magicsquare[row][col]!=0){
				col = curCOl -1;
				row = curROw;
			}
			curROw = row;
			curCOl = col;
			magicsquare[curROw][curCOl]=i;
		}
		printMatrix();
	}
	private void printMatrix() {
		for(int i = 0 ; i < magicsquare.length;i++){
			System.out.println(Arrays.toString(magicsquare[i]));
		}
	}
	public static void main(String[] args){
		int n = 4 ;
		new MagicSquare().generateMagicsquare(n);
	}
}
