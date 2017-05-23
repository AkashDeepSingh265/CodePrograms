package Mathematics;

public class Median {

    private int getMedian(int[] a1, int[] a2){
        int m = a1.length;
        int n = a2.length;
        int i = 0 ;
        int j = 0 ;
        int count = 0;
        int m1 = 0,m2 = 0;
        int mid = (m+n)/2;
        while(i<m&&j<n&&count<=mid){
            if(a1[i] <= a2[j]){
                if(count==mid-1){
                    m1 = a1[i];
                }
                if(count==mid){
                    m2 = a1[i];
                }
                i++;
            }else{
                if(count==mid-1){
                    m1 = a2[j];
                }
                if(count==mid){
                    m2 = a2[j];
                }
                j++;
            }
            count++;
        }
            if(i==m){
                if(count<=mid-1){
                    m2 = a2[mid-m];
                    m1 = a2[mid-m-1];
                }else{
                    if(count==mid){
                        m2 = a2[mid-m];
                    }
                }
            }
            if(j==n){
                if(count<=mid-1){
                    m2 = a1[mid-n];
                    m1 = a1[mid-n-1];
                }else{
                    if(count==mid){
                    m2 = a1[mid-n];
                    }
                }
            }
        if((m+n)%2==1)return m2;   
        return (m1+m2)/2;
    }
    public static void main(String[] args){
        int[] a = {6,7,8,9,10,11};
        int[] b = {1,2,3,4,5};
        System.out.println(new Median().getMedian(a,b));       
    }
}