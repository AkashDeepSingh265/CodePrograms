
public class SwapNumbersUsingXor {
	
	public static void main(String[] args){
		char a = '1';
		char b = '2';
		a = (char) (a^b);
		b=(char) (a^b);
		a=(char) (a^b);
		System.out.println(a+","+b);
	}
}
