package DynamiProgramming;

public class PalindromePartitioning {

    public int minCut(String A) {
        int n = A.length();
        boolean[][] palindrome = new boolean[n][n];
        int[][] minCost = new int[n][n];

        for(int i=0;i<n;i++){
            palindrome[i][i] = true;
            minCost[i][i] = 0;
        }

        for(int length = 2; length <=n; length++){
            for (int i=0;i<=n-length;i++){
                int j = i+length-1;
                if(length ==2 ){
                    if(A.charAt(i) == A.charAt(j)){
                        palindrome[i][j] = true;
                        minCost[i][j] = 0;
                    }else{
                        palindrome[i][j] = false;
                        minCost[i][j] = 1;
                    }
                }else{
                    palindrome[i][j] = (A.charAt(i) == A.charAt(j)) && palindrome[i+1][j-1];
                    if (palindrome[i][j]){
                        minCost[i][j] = 0;
                    }else {
                        minCost[i][j] = Integer.MAX_VALUE;
                        for(int k = i;k<=j-1;k++){
                            minCost[i][j] = Math.min(minCost[i][j],minCost[i][k]+1+minCost[k+1][j]);
                        }
                    }
                }

            }
        }
        return minCost[0][n-1];
    }
}
