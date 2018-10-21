package Arrays;

import java.util.*;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int a=0 ;
        Iterator<Integer> it = A.iterator();
        int i=1;
        int sum_true=0;
        int sum_error=0;
        while(it.hasNext()){
            int value = it.next();
            sum_error=sum_error+value;
            sum_true=sum_true+i;
            a=a^i;
            a=a^value;
            i++;
        }
        int b = sum_true-sum_error+a;
        ArrayList<Integer> return_list = new ArrayList<Integer>();
        return_list.add(a);
        return_list.add(b);
        return return_list;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        ArrayList<Integer> return_list = new ArrayList<Integer>();
        return_list.add(3);return_list.add(1);return_list.add(2);return_list.add(5);return_list.add(3);
        System.out.print(sol.repeatedNumber(return_list));
    }
}
