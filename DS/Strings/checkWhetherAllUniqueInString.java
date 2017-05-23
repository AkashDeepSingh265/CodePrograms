package Strings;

// check without using extra space 
//we use checker as int to store the index of visited char like for b 0000.....10;
public class checkWhetherAllUniqueInString {

	public static boolean checkUnique(String s){
		int checker = 0 ;
		int val ;
		for(int i = 0 ; i < s.length();i++){
			val = s.charAt(i) - 'a';
			if((checker&(1<<val))>0){
				return false;
			}
			checker |= 1<<val;
		}
		return true;
	}
	public static void main(String[] args){
		String s = "akash";
		System.out.println(checkWhetherAllUniqueInString.checkUnique(s));
	}
}
