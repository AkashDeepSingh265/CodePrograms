package Matrix;

public class SpiralMatrix {

	public static void printMatrix(int[][] max){
		int startRow = 0;
		int startCol = 0;
		int endRow = max.length-1;
		int endCol = max[0].length-1;
		int i;
		char c = 'x';
		while(startRow<=endRow&&startCol<=endCol){
			for(i = startCol ; i <=endCol;i++){
				System.out.print(max[startRow][i]+" ");
			}
			startRow++;
			for(i = startRow ; i <=endRow;i++){
				System.out.print(max[i][endCol]+ " ");
			}
			endCol--;
			if(endRow>=startRow){
				for(i = endCol ; i>=startCol ;i--){
					System.out.print(max[endRow][i] + " ");
				}
			endRow--;
			}
			if(endCol>=startCol){
				for(i = endRow ; i>=startRow;i--){
					System.out.print(max[i][startCol]+ " ");
				}
				startCol++;
			}
			
			c = (c == 'x') ? 'o':'x'; 
		}
	}
	
	public static void main(String[] args){
		int a[][] = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18},
		        {19, 20 ,21 ,22, 23, 24}
		    };
		SpiralMatrix.printMatrix(a);
	}
}
