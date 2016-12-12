package Combinations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IntegerAsSumOf4Numbers {

	public static int getNumOfWays(int num,int prev,int pos,int sum){
		if(sum<0 || sum < prev)
			return 0;
		if(pos==1)
			return 1;
		int count=0;
		for(int i = prev ; i < num;i++){
			if(pos*i > sum)
				break;
			count += getNumOfWays(num,i, pos-1, sum-i);
		}
		return count;
	}
	
	static void findSubstrings(String s) {
        int length = s.length();
        List<String> subStringList = new ArrayList<String>();
        int firstVowel;
        int firstConsonant;
        for(int i = 0 ; i <length;i++){
          if(isVowel(s.charAt(i))){
              for(int j=i+1;j<length;j++){
                  if(!isVowel(s.charAt(j))){
                      subStringList.add(s.substring(i,j+1));
                  }
              }
          }  
        }
        Collections.sort(subStringList);
        System.out.println(subStringList.get(0));
        System.out.println(subStringList.get(subStringList.size()-1));
    }

    static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i'|| c == 'o' || c == 'u';
    }
	public static int countWays(int n)
	{
	    int counter = 0; // Initialize result
	 
	    // Generate all possible quadruplet and increment
	    // counter when sum of a quadruplet is equal to n
	    for (int i = 1; i < n; i++)
	        for (int j = i; j < n; j++)
	            for (int k = j; k < n; k++)
	                for (int l = k; l < n; l++)
	                    if (i + j + k + l == n)
	                       counter++;
	    return counter;
	}
	
	public static void main(String[] args){
		
		//findSubstrings("rejhiuecumovsutyrulqaeuouiecodjlmjeaummaoqkexylwaaopnfvlbiiiidyckzfhe");
		findSubstrings("aaaaa");
//		for(int num = 5 ; num<300;num++){
//			System.out.println(getNumOfWays(num,1,4,num));
//			System.out.println(countWays(num));
//			System.out.println("===========================");
//		}
		
		
	}
}
