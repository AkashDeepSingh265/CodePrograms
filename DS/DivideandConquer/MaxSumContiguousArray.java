package DS.DivideandConquer;
import java.util.*;

public class MaxSumContiguousArray {

    public int maxSubArray(final List<Integer> A) {
        return maxSubArrayDivideAndConquer(A,0,A.size()-1);
    }

    public int maxSubArrayDivideAndConquer(final List<Integer> A,int start,int end){
        if(start == end)
            return A.get(start);
        int mid = (start+end)/2;
        int max_left = maxSubArrayDivideAndConquer(A,start,mid);
        int max_right = maxSubArrayDivideAndConquer(A,mid+1,end);
        int left_sum_max = Integer.MIN_VALUE;
        int cur_left_sum=0;
        int right_sum_max = Integer.MIN_VALUE;
        int cur_right_sum=0;
        for(int i =mid;i>=0;i--){
            cur_left_sum+=A.get(i);
            if(cur_left_sum>left_sum_max){
                left_sum_max=cur_left_sum;
            }
        }

        for(int i =mid+1;i<A.size();i++){
            cur_right_sum+=A.get(i);
            if(cur_right_sum>right_sum_max){
                right_sum_max=cur_right_sum;
            }
        }

        return Math.max(Math.max(max_left,max_right),left_sum_max+right_sum_max);
    }

    public static void main(String[] args){
        Integer[] integer_list = new Integer[]{-2,1,-3,4,-1,2,1,-5,4};
        List<Integer> input = Arrays.asList(integer_list);
        MaxSumContiguousArray obj = new MaxSumContiguousArray();
        System.out.print(obj.maxSubArray(input));
    }
}
