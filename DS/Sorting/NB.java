package Sorting;
import java.util.Arrays;
import java.util.Random;


public class NB {
   
    private void compute(){
        int[] N={3,6,5,1,2,4,8,7,9};
        int[] B={5,1,3,2,4,6,9,8,7};
        findMatchingNB(N,B,0,N.length-1);
        System.out.println("N: "+Arrays.toString(N));
        System.out.println("B:"+Arrays.toString(B));
    }
   
    private void findMatchingNB(int[] n, int[] b, int start, int end) {
        int pivotN;
        int pivotB;
        if(start < end){
            pivotN = new Random().nextInt(end-start+1) + start;
            pivotB=findPivotNSortB(pivotN,b,n,start,end);
            pivotN=findPivotBSortN(pivotB,n,b,start,end);
            findMatchingNB(n, b,start ,pivotB-1 );
            findMatchingNB(n, b,pivotB+1 , end);
        }
    }


    private int findPivotBSortN(int index, int[] n,int[] b, int start, int end) {
        int l = start;
        int r = end;
        int temp;
        while(l<r){
            while(l< end && n[l]<=b[index]){
                l++;
            }
            while(n[r]>b[index]){
                r--;
            }
            if(l<r){
                temp=n[l];
                n[l]=n[r];
                n[r]=temp;
            }
        }
        temp = n[r];
        n[r]=n[findindex(b[index], n, start, end)];
        n[findindex(b[index],n, start, end)] = temp;
        return r;
    }

    private int findindex(int nutValue, int[] b, int start, int end) {
        for(int i=start;i<=end;i++){
            if(b[i]==nutValue){
                return i;
            }
        }
        return -1;
    }


    private int findPivotNSortB(int index, int[] b,int n[], int start, int end) {
        int l = start;
        int r = end;
        int temp;
        while(l<r){
            while(l< end && b[l]<=n[index]){
                l++;
            }
            while(b[r]>n[index]){
                r--;
            }
            if(l<r){
                temp=b[l];
                b[l]=b[r];
                b[r]=temp;
            }
        }
        temp = b[r];
        b[r]=b[findindex(n[index], b, start, end)];
        b[findindex(n[index], b, start, end)] = temp;
        return r;
    }


    public static void main(String[] args){
        new NB().compute();
    }
}