package DynamicProgramming;

public class LongestCommonSubsequence {
	
	public static void printLCS(char[] m , char[] n){
		int mlength = m.length;
		int nlength = n.length;
		int[][] lcs = new int[mlength+1][nlength+1];
		
		for(int i = 0 ; i<= mlength ;i++){
			for(int j=0;j<=nlength;j++){
				if(i==0||j==0)continue;
				else{
					if(m[i-1]==n[j-1]){
						lcs[i][j] = lcs[i-1][j-1] + 1;
					}else{
						lcs[i][j]=lcs[i-1][j];
						if(lcs[i][j-1]>lcs[i][j]){
							lcs[i][j]=lcs[i][j-1];
						}
					}
				}
			}
		}
		System.out.println(lcs[mlength][nlength]);
	}
	
	public static void main(String[] args){
		char[] m = "AGGTAB".toCharArray();
		char[] n = "GXTXAYB".toCharArray();
		LongestCommonSubsequence.printLCS(m, n);
	}
}
