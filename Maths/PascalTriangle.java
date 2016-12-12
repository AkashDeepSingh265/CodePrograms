
public class PascalTriangle {

	public static void generatePascalTriangle(int n){
		int[] array = null;
		int[] prev;
		for(int i = 1 ; i <=n ; i++){
			prev=array;
			array=new int[i];
			for(int j = 0 ; j <i;j++){
				if(j==0 || j==i-1){
					array[j]=1;
					System.out.print("1 ");
				}else{
					int value = prev[j]+prev[j-1];
					System.out.print(value+" ");
					array[j] = value;
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		generatePascalTriangle(10);
	}
}
