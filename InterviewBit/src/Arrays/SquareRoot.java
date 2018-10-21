package Arrays;

/**
 * Created by akash.ds on 25/08/18.
 */
public class SquareRoot {
    public int sqrt(int a) {
        if(a==0 || a==1){
            return a;
        }

        long start = 1 ;
        long end = a;

        while (start <=end){
            long mid = start + (end - start)/2;

            if(mid*mid == a ||(mid+1 <=end && mid*mid < a && (mid+1)*(mid+1) >a)){
                return (int) mid;
            }

            if (mid-1 >=start && ((mid-1)*(mid-1)) < a && mid*mid >a){
                return (int) mid-1;
            }
            if (mid*mid < a){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
