package Matrix;

public class SpiralMatrix {

	public static void printMatrixInspiral(int[][] matrix){
		int numRows = matrix.length;
		int numColumns = matrix[0].length;
		int startCol=0;
		int endCol = numColumns-1;
		int startRow=0;
		int endRow = numRows-1;
		while(startCol<=endCol && startCol<=endRow){
			for(int i = startCol ; i <= endCol ;i++){
				System.out.print(matrix[startRow][i]+" ");
			}
			startRow++;
			
			for(int i = startRow ; i <=endRow ;i++){
				System.out.print(matrix[i][endCol]+" ");
			}
			endCol--;
			
			if(startRow<=endRow){
				for(int i = endCol ; i >= startCol ;i--){
					System.out.print(matrix[endRow][i]+" ");
				}
				endRow--;
			}
			if(startCol<endCol){
				for(int i = endRow ; i >= startRow ;i--){
					System.out.print(matrix[i][startCol]+" ");
				}
				startCol++;
			}
			
		}
	}
	
	public static void main(String[] args){
		printMatrixInspiral(MatrixGeneraotr.generateMatrix());
	}
}
