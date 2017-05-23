package CF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Penguin_Matrix_289_B {
	public void compute(){
		Scanner in = null;
		try{
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int rows = in.nextInt();
			int cols = in.nextInt();
			int d = in.nextInt();
			int[] matrix = new int[rows*cols];
			matrix[0]=in.nextInt();
			int modVal = matrix[0]%d;
			for(int i=1;i<rows*cols;i++){
				matrix[i] = in.nextInt();
				if(matrix[i]%d!=modVal){
					System.out.println(-1);
					return;
				}
			}
			Arrays.sort(matrix);
			int median = (rows*cols-1)/2;
			int medianElement = matrix[median];
			int moves = 0;
			for(int i=0;i<rows*cols;i++){
				moves = moves + Math.abs((matrix[i]-medianElement))/d;
			}
			System.out.println(moves);
		}finally{
			in.close();
		}
	}
	public static void main(String[] args){
		new Penguin_Matrix_289_B().compute();
		System.exit(0);
	}
}
