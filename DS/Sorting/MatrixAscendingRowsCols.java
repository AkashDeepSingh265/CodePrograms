package Sorting;

import javax.print.attribute.standard.Finishings;

public class MatrixAscendingRowsCols {

	public void findElement(int[][] matrix,int element){
		int numRows = matrix.length;
		int numcols = numRows;
		int curRow = 0;
		int curCol = numcols-1;
		int curElem;
		boolean found = false;
		while(curRow<numRows&&curCol>=0){
			curElem = matrix[curRow][curCol];
			if(curElem==element){
				System.out.println(("row : "+curRow+"\n col:"+curCol));
				found = true;
				break;
			}else {
				if(element>curElem){
					curRow++;
				}else{
					curCol--;
				}
			}
		}
		if(!found){
			System.out.println("Element not present in matrix");
		}
		
	}
	
	public static void main(String[] args){
		int matrix[][] = {{1,4,8,16},
				{10,12,14,18},
				{20,22,24,26},
				{25,30,31,35}
		};
		new MatrixAscendingRowsCols().findElement(matrix,12);
	}
}
