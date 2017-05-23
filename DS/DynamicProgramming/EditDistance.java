package DynamicProgramming;

//Minimum nos of operations required to convert String X to Y 
public class EditDistance {

	public static final int REPLACE_COST = 1;
	public static final int DELETE_COST = 1;
	public static final int INSERT_COST = 1;
	public static int editDistanceDp(char[] x , char[] y ){
		int lenX = x.length;
		int lenY = y.length;
		int[][] ed = new int[lenX+1][lenY+1];
		int replaceCost,deleteCost,insertCost,min;
		for(int i = 0 ; i < lenY;i++){
			ed[lenX][i] = lenY-i; 
		}
		for(int j = 0 ; j < lenX;j++){
			ed[j][lenY] = lenX-j; 
		}
		
		for(int i = lenX-1;i>=0;i--){
			for(int j = lenY-1;j>=0;j--){
				replaceCost = (x[i]==y[j] ) ?  0 : REPLACE_COST;
				 replaceCost = replaceCost + ed[i+1][j+1];
				deleteCost = DELETE_COST; 
				deleteCost += ed[i+1][j];
				insertCost = INSERT_COST; 
				insertCost += ed[i][j+1];
				min = Math.min(replaceCost,deleteCost);
				min = Math.min(min,insertCost);
				ed[i][j]=min;
			}
		}
		return ed[0][0];
	}
	public static void main(String[] args){
		System.out.println(EditDistance.editDistanceDp("mart".toCharArray(),"karma".toCharArray()));
	}
}
