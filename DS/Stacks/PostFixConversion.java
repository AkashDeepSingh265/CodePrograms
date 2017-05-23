package Stacks;

import java.util.HashMap;

public class PostFixConversion {

	private StringBuilder output;
	private LinkedListStack<Character> stack;
	private HashMap<Character,Integer> precedenceMap ;
	public PostFixConversion(){
		output = new StringBuilder();
		stack = new LinkedListStack<>();
		precedenceMap = new HashMap<>();
		precedenceMap.put('*', 13);
		precedenceMap.put('/',13);
		precedenceMap.put('+',12);
		precedenceMap.put('-',12);
		
	}
	public String getInfixExpression(String input){

		for(int i = input.length()-1; i>=0;i--){
			char c = input.charAt(i);
			switch (c) {
			case ')':
				stack.push(c);
				break;
			case '(':
				while(stack.getTop()!=')'){
					output.append(stack.pop());
				}
				stack.pop();
				break;
			case '*':
			case '/':
			case '+':
			case '-':
				if(!stack.isEmpty()){
					if(stack.getTop()!=')'&&precedenceMap.get(c)<precedenceMap.get(stack.getTop())){
						do{
							output.append(stack.pop());
						}while(!stack.isEmpty() && precedenceMap.get(c)<precedenceMap.get(stack.getTop()));
					}
				}
				stack.push(c);
				break;
			default:
				output.append(c);
				break;
			}
		}
		
		if(!stack.isEmpty()){
			while(!stack.isEmpty()){
				output.append(stack.pop());
			}
		}
		return output.reverse().toString();
	
	}
	public String getPostFixExpression(String input){
		for(int i = 0 ; i<input.length();i++){
			char c = input.charAt(i);
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case ')':
				while(stack.getTop()!='('){
					output.append(stack.pop());
				}
				stack.pop();
				break;
			case '*':
			case '/':
			case '+':
			case '-':
				if(!stack.isEmpty()){
					if(stack.getTop()!='('&&precedenceMap.get(c)<=precedenceMap.get(stack.getTop())){
						do{
							output.append(stack.pop());
						}while(!stack.isEmpty() && precedenceMap.get(c)<=precedenceMap.get(stack.getTop()));
					}
				}
				stack.push(c);
				break;
			default:
				output.append(c);
				break;
			}
		}
		if(!stack.isEmpty()){
			while(!stack.isEmpty()){
				output.append(stack.pop());
			}
		}
		return output.toString();
	}
	
	public static void main(String[] args){
		String input = "a/b*c-d+e/f/(g+h)";
		//String input = "((((1*(2+3))-3)+4)*5)";
		System.out.println(new PostFixConversion().getPostFixExpression(input));
		System.out.println(new PostFixConversion().getInfixExpression(input));
	}
}
