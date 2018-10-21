package Arrays;

import  java.util.*;

public class AntiDiagonal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<List<Integer>> A) {
        int i=0;
        int j = A.get(0).size()-1;
        ArrayList<ArrayList<Integer>> return_list= new ArrayList<ArrayList<Integer>>();
        for (int t=0;t<=j;t++){
            int cur_i =0;
            int cur_j =t;
            return_list.add(new ArrayList<Integer>());
            while(cur_i>=0 && cur_i <= A.size()-1 && cur_j>=0 && cur_j<=A.get(0).size()-1){
                System.out.print(cur_i);
                System.out.print(cur_j);
                return_list.get(t).add(A.get(cur_i).get(cur_j));
                cur_i++;
                cur_j--;
            }
        }

        for (int t=1;t<=A.size()-1;t++){
            int cur_i =t;
            int cur_j =A.get(0).size()-1;
            return_list.add(new ArrayList<Integer>());
            while(cur_i>=0 && cur_i <= A.size()-1 && cur_j>=0 && cur_j<=A.get(0).size()-1){
                return_list.get(j+t).add(A.get(cur_i).get(cur_j));
                cur_i++;
                cur_j--;
            }
        }
        return return_list;
    }

    public static void main(String[] args){
        ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
        group.add(Arrays.asList(1, 2, 3));
        group.add(Arrays.asList(4, 5, 6));
        group.add(Arrays.asList(7, 8, 9));
        AntiDiagonal sol = new AntiDiagonal();
        System.out.print(sol.diagonal(group));
    }

}
