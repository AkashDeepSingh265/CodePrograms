package Arrays;
import java.util.*;

/**
 * Created by akash.ds on 18/08/18.
 */
public class RepeatAndMissingNumberXOR {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        int xor = 0;
        ArrayList<Integer> set_bit = new ArrayList<Integer>();
        ArrayList<Integer> unset_bit = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i =1;i<=n;i++){
            xor^=i;
        }
        for(Integer i : A){
            xor^=i;
        }
        int bit = 1;

        // while(( xor & bit ) == 0){
        //     bit = bit << 1;
        // }
        bit = xor & ~(xor-1);

        int xor_set = 0;
        int xor_unset=0;
        for(int i =1;i<=n;i++){
            if((i & bit)==1){
                xor_set^=i;
            }else{
                xor_unset^=i;
            }

        }
        for(Integer i : A){
            if((i & bit)==1){
                xor_set^=i;
            }else{
                xor_unset^=i;
            }
        }
        result.add(xor_set);
        result.add(xor_unset);
        return result;
    }
}
