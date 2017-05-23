package Assignments;

public class Literals {
	static void intLiterals(){
		byte b = 125;
		byte c = 13;
		byte d = (byte) (b + c);
		System.out.println(d);
		int x = 0XFFFF;
		System.out.println(x);
	}
	
	static void floatingPoint(){
		float d = 56.1234353453453534535F;
		System.out.println(d);
	}
	static void charLiteral(){
		char d = (char) -67;
		char c = (char) 65590;
		System.out.println(d);
	}
	public static void main(String[] args){
		Literals.charLiteral();
		Literals.intLiterals();
	}
}
