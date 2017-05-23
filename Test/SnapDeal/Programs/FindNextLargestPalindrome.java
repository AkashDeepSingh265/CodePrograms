package Programs;

import java.util.Arrays;

public class FindNextLargestPalindrome {

	private static  void generateNextPalindromeUtil (int num[], int n )
	{
	    int mid = n/2;
	 
	    boolean leftsmaller = false;
	 
	    int i = mid - 1;
	 
	    int j = (n % 2)==1? mid + 1 : mid;
	 
	    while (i >= 0 && num[i] == num[j]){
	        i--;
	    	j++;
	    }
	    if ( i < 0 || num[i] < num[j])
	        leftsmaller = true;
	 
	    while (i >= 0)
	    {
	        num[j] = num[i];
	        j++;
	        i--;
	    }
	 
	    if (leftsmaller == true)
	    {
	        int carry = 1;
	        i = mid - 1;
	 
	        if (n%2 == 1)
	        {
	            num[mid] += carry;
	            carry = num[mid] / 10;
	            num[mid] %= 10;
	            j = mid + 1;
	        }
	        else
	            j = mid;
	 
	        while (i >= 0)
	        {
	            num[i] += carry;
	            carry = num[i] / 10;
	            num[i] %= 10;
	            num[j++] = num[i--]; 
	        }
	    }
	}
	 
	private static void generateNextPalindrome( int num[], int n )
	{
	    int i;
	    if( AreAll9s( num, n ) )
	    {
	        System.out.println( "1 ");
	        for( i = 1; i < n; i++ )
	           System.out.println( "0 " );
	        System.out.println( "1" );
	    }
	    else{
	        generateNextPalindromeUtil ( num, n );
	        System.out.println(Arrays.toString(num).replaceAll(",","").replace("[","").replace("]",""));
	    }
	}
	 
	 private static boolean AreAll9s( int[] num, int n )
	{
	    
	    for(int i = 0; i < n; ++i )
	        if( num[i] != 9 )
	            return false;
	    return true;
	}
	 
	
	 
	public static void  main(String[] args)
	{
	    int num[] = {1,2,2,1};
	   FindNextLargestPalindrome.generateNextPalindrome( num, num.length);
	}
	
	
	
	
}
