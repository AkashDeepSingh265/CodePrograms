package CF;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AandBIntersectingString {

	public static long computeValue(){
		Scanner s = null;
		s = new Scanner(new BufferedInputStream(System.in));
		int[] values = new int[26];
		
		for(int i = 0 ; i < 26;i++){
			values[i] = s.nextInt();
		}
		
		String str = s.next();
		int[] sum = new int[str.length()];
		if(str.length()<=1) return 0;
		ArrayList<ArrayList<Integer>> posList = new ArrayList<>(26);
		
		for(int i = 0 ; i < 26;i++){
			ArrayList<Integer> lst = new ArrayList<>();
			posList.add(lst);
		}
		sum[0] = values[str.charAt(0)-'a'];
		posList.get(str.charAt(0)-'a').add(0);
		for(int i = 1 ; i < str.length();i++){
			posList.get(str.charAt(i)-'a').add(i);
			sum[i] =  sum[i-1] + values[str.charAt(i)-'a'];
		}
		
		long res =0;
		for(int i = 0 ; i < 26; i ++){
			if(posList.get(i).size()>0){
				HashMap<Integer,Integer> sumVsCountMap = new HashMap<>();
				for(int p : posList.get(i)){
					if( p-1>=0 && sumVsCountMap.get(sum[p-1])!=null){
						res = res +sumVsCountMap.get(sum[p-1]);
					}
					if(sumVsCountMap.get(sum[p])!=null){
						sumVsCountMap.put(sum[p], sumVsCountMap.get(sum[p])+1);
					}else{
						sumVsCountMap.put(sum[p], 1);
					}
				}
			}
		}
		
		s.close();
		return res;
	}
	public static void main(String[] args){
		
		System.out.println(AandBIntersectingString.computeValue());
	}
}
