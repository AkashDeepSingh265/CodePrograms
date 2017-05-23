package Strings;

public class StringInterleaving {

	private void printAllInterleavingStrings(String a,String b , char[] c , int m , int n ,int depth){
		if(m==0&&n==0){
			System.out.println(new String(c));
		}
		if(m!=0){
			c[depth] = a.charAt(a.length()-m);
			printAllInterleavingStrings(a, b, c, m-1, n, depth+1);
		}
		if(n!=0){
			c[depth]=b.charAt(b.length()-n);
			printAllInterleavingStrings(a, b, c, m, n-1, depth+1);
		}
	}
	public static void main(String[] args){
		String a = "abc";
		String b = "def";
		char[] c = new char[6];
		new StringInterleaving().printAllInterleavingStrings(a, b, c,a.length(),b.length(),0);
	}
}
