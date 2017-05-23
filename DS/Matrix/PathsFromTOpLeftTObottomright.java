package Matrix;

import java.util.Arrays;

public class PathsFromTOpLeftTObottomright {

	public static int  numberOfPaths(int m, int n)
	{
	   if (m == 1 || n == 1)
	        return 1;
	   return  numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
	}
	public static int numberOfPaths(int m , int n , int row , int col ){
		if(row>m-1 || col >n-1) return 0;
		if(row == m-1 && col == n-1) return 1;
		return numberOfPaths(m, n, row+1, col) + numberOfPaths(m, n, row, col+1);
	}
	
	public static void printPaths(int[][] mat, int row , int col,int[] paths){
		int m =mat.length;
		int n = mat[0].length;
		if(row>m-1 || col >n-1) return;
		paths[row+col]=mat[row][col];
		if(row == m-1 && col == n-1){
			System.out.println(Arrays.toString(paths));
			return;
		}
		printPaths(mat,row+1, col, paths);
		printPaths(mat, row, col+1, paths);
	}
	
	public static void main(String[] args){
		int[][] matrix ={{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
		};
		int[] paths = new int[matrix.length+matrix[0].length-1];
		PathsFromTOpLeftTObottomright.printPaths(matrix,0, 0, paths);
	}
}
