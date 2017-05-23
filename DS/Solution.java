import java.io.BufferedInputStream;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


public class Solution {
    
    public static void createTable(){
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int n = s.nextInt();
        int D = s.nextInt();
        int[] rad  = new int[n];
        int[] cost = new int[n];
        int[] tab = new int[n];
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        for(int i = 0 ; i < n ; i ++){
            rad[i] = s.nextInt();
        }
        
        for(int i = 0 ; i < n ; i ++){
            cost[i] = s.nextInt();
        }
        
        for(int i = 0 ; i < n ; i ++){
        	ArrayList<Integer> indList = getIndex(rad,D,i);
        	if(indList.size()==0){
        		tab[i] = 0;
        		continue;
        	}
        	int mincost = Integer.MAX_VALUE;
        	int minInd = -1;
        	for(Integer in : indList){
        		if(cost[in]<mincost){
        			mincost=cost[in];
        			minInd = in;
        		}
        	}
        	tab[i]=minInd+1;
        }
        System.out.println(Arrays.toString(tab).replaceAll(",","").replace("[","").replace("]",""));
    }
    
	private static ArrayList<Integer> getIndex(int[] rad, int d,int ind) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < rad.length;i++){
			if(rad[i]>=d-rad[ind]){
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String args[] ) throws Exception {
		Solution.createTable();
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}
