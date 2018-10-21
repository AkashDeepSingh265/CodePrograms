package Arrays;
import java.util.*;

/**
 * Created by akash.ds on 19/08/18.
 * https://www.interviewbit.com/problems/find-permutation/
 */

public class FindPermutation {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int countD = 0;
        for(int i=0;i < A.length();i++){
            if(A.charAt(i)=='D') {
                countD++;
            }
        }
        int startValue = 1+countD;
        int increment_val = startValue+1;
        int decrement_val = startValue-1;
        result.add(startValue);
        for(int i=0;i < A.length();i++){
            if(A.charAt(i)=='D') {
                result.add(decrement_val--);
            }else{
                result.add(increment_val++);
            }
        }
        return result;
    }
}

