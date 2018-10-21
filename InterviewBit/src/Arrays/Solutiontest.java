package Arrays;

import java.util.*;

public class Solutiontest {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> columns = new ArrayList<Integer>();
        int m = a.size();
        int n = a.get(0).size();
        for(int i = 0 ; i < m ; i++){
            for(int j=0; j<n; j++){
                if(a.get(i).get(j)==0)
                    rows.add(i);
                columns.add(j);
            }
        }

        Iterator<Integer> it = rows.iterator();
        while(it.hasNext()){
            int row_val = it.next();
            for(int i = 0 ; i <n ; i++){
                a.get(row_val).set(i,0);
            }
        }

        Iterator<Integer> it1 = columns.iterator();
        while(it1.hasNext()){
            int col_val = it1.next();
            for(int i = 0 ; i <m ; i++){
                a.get(i).set(col_val,0);
            }
        }

    }

    public static void main(String[] args){
    }
}
