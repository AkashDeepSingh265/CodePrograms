package Arrays;
import java.util.*;

/**
 * Created by akash.ds on 19/08/18.
 */
public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int start = 0;
        int end = n-1;
        int row_start = start;
        int row_end = end;
        int col_start = start;
        int col_end = end;
        while(row_start < row_end){

            int row1 = row_start;
            int col1 = col_start;

            int row2 = row_start;
            int col2 = col_end;

            int row3 = row_end;
            int col3 = col_end;

            int row4 = row_end;
            int col4 = col_start;

            while(col1 < col_end){
                int val1 = A.get(row1).get(col1);

                int val2 = A.get(row2).get(col2);

                int val3 = A.get(row3).get(col3);

                int val4 = A.get(row4).get(col4);


                A.get(row2).set(col2,val1);

                A.get(row3).set(col3,val2);

                A.get(row4).set(col4,val3);

                A.get(row1).set(col1,val4);

                col1++;
                row2++;
                col3--;
                row4--;
            }
            row_start++;
            row_end--;
            col_start++;
            col_end--;
        }
    }
}
