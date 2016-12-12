package Matrix;

public class MatrixGeneraotr {
	
	public static int[][] generateMatrix(){
		int[][] matrix = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		return matrix;
	}
	
	public static void printMatrix(int[][] mat){
		if(mat==null)
			return;
		int numRows = mat.length;
		int numCols = mat[0].length;
		for(int i = 0; i< numRows;i++ ){
			for(int j=0;j<numCols;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		printMatrix(generateMatrix());
	}
}
