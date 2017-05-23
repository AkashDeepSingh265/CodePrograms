package Sorting;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IterativeQS {
   
    private int partition(int[] A,int start , int end){
        int pivotElem = A[start];
        int l = start;
        int r = end;
        int temp;
        while(l<r){
            while(l< end && A[l]<=pivotElem){
                l++;
            }
            while(A[r]>pivotElem){
                r--;
            }
            if(l<r){
                temp=A[l];
                A[l]=A[r];
                A[r]=temp;
            }
        }
        A[start] = A[r];
        A[r]=pivotElem;
        return r;
    }
    private void iterativeQuiS(int[] A,int start,int end){
        int top=-1;
        int l,r,p;
        int[] s=new int[end-start+1];
        s[++top] = end;
        s[++top] = start;
        
        while(top>=0){
            l = s[top--];
            r = s[top--];
            if(l<r){
                p = partition(A,l,r);
                    s[++top] = p-1;
                    s[++top] = l;
                    s[++top] = r;
                    s[++top] = p+1;
            }
        }
    }
   
    public static void main(String[] args){
        int [] numbers = {5,3,33,9,99,2,4,1,22,7,4,10,8};
        new IterativeQS().iterativeQuiS(numbers, 0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }
}