import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private boolean isPrime(int number){
       
       // if(number!=2 && number%2==0) return false;
        for(int i = 2;2*i<=number;i++){
            if(number%i ==0){
                return false;
            }
        }
        return true;
    }
//    public int RotateInt(int number){
//        int length = String.valueOf(number).length();
//        if(length==1) return number;
//        int valueAtFirstIndex = Character.getNumericValue(String.valueOf(number).charAt(0));
//        return (number - ((int)Math.pow(10,length-1))*valueAtFirstIndex )*10 + valueAtFirstIndex;
//    }
    public String RotateString(String number){
       // String num = String.valueOf(number);
        int length = number.length();
        if(length==1) return number;
        number = number.concat(number);
        number = number.substring(1,length+1);
        return number;
    }
    private boolean isCicrularPrime(int number){
        int length = String.valueOf(number).length();
        String tempNum= number+"";
        for(int i = 0 ; i < length-1;i++){
            tempNum = RotateString(tempNum);
            if(!isPrime(Integer.parseInt(tempNum))){
                return false;
            }
        }
        return true;
    }
    public void numberOfCircularPrimes() throws Exception{
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(System.out);
        //int N = Integer.parseInt(reader.readLine());
    	int N=1000000;
        int count=0;
        for(int i = 2;i<=N;i++){
           // System.out.println(i+":"+isPrime(i));
            if(isPrime(i)&&isCicrularPrime(i)){
            	//System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
        //writer.print(count);
    }
    public static void main(String args[] ) throws Exception {
        Solution obj = new Solution();
        obj.numberOfCircularPrimes();
       // System.out.println(obj.RotateString("011"));
        //System.out.println(obj.isPrime(197));
        //System.out.println(obj.isCicrularPrime(197));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}