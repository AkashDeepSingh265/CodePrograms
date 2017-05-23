package Programs;

import java.util.Stack;

public class Paranthesis {

	public static boolean checkBalancedParanthesis(String expp){
		char[] exp = expp.toCharArray();
		Stack<Character> s = new Stack<>();
		int i = 0 ;
		char pop;
		while(i<exp.length){
			if(exp[i]=='{'||exp[i]=='('||exp[i]=='['){
				s.push(exp[i]);
			}
			
			if(exp[i]=='}'||exp[i]==')'||exp[i]==']'){
				if(s.isEmpty())return false;
				pop = s.pop();
				if(!(exp[i]=='}'&&pop=='{'||exp[i]==')'&&pop=='('||exp[i]==']'&&pop=='[')){
					return false;
				}
			}
			i++;
		}
		if(s.isEmpty())return true;
		return false;
	}
	public static void main(String[] args){
		System.out.println(Paranthesis.checkBalancedParanthesis("{{{}}}[][][][][]"));
	}
}
