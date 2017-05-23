package Regex;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args){
    	List<Integer> lst = new Vector<Integer>();
    	int[] intArray = new int[] {1, 2, 3, 4, 5};
    	System.out.println(Arrays.toString(intArray)); 
    Pattern pat = Pattern.compile("(\\d\\d)\\1");
    Matcher matcher = pat.matcher("121223232323");
    while(matcher.find()){
    	System.out.format("I found the text" +" \"%s\" starting at " +"index %d and ending at index %d.%n",matcher.group(),matcher.start(),matcher.end());
    }

    }
}