package DynamiProgramming;

/**
 * Created by akash.ds on 13/09/18.
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;

public class PartitionArrayEqualSum {

    public static boolean findSubset(int[] array,int n){
        int sum = 0 ;
        for(int i = 0 ; i < n;i++){
            sum = sum + array[i];
        }

        if(sum%2 == 1){
            return false;
        }
        boolean[][] sumDp = new boolean[sum/2+1][n+1];

        for(int i = 0; i <= n; i++)
            sumDp[0][i] = true;
        for(int i = 1; i <= sum / 2; i++)
            sumDp[i][0] = false;


        for(int i =1;i<= sum/2;i++){
            for(int j = 1;j<=n;j++){
                sumDp[i][j] = sumDp[i][j-1];
                if(i >= array[j-1]){
                    sumDp[i][j] = sumDp[i][j-1] || sumDp[i-array[j-1]][j-1];
                }
            }
        }
        return sumDp[sum/2][n];
    }

    public static void main (String[] args) {
        //code
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int i, n;
            while(t != 0) {
                n = sc.nextInt();
                int arr[] = new int[n];
                for(i = 0; i < n; i++)
                    arr[i] = sc.nextInt();
                if(findSubset(arr, n))
                    System.out.println("YES");
                else
                    System.out.println("NO");
                t -= 1;
            }
    }
}
