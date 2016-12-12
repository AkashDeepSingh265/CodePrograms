
public class PalindromeInteger {

	public static boolean isPalindrome(int num){
		int temp=num;
		int reverseInt = 0;
		while(temp>0){
			reverseInt = reverseInt*10 + temp%10;
			temp=temp/10;
		}
		return reverseInt == num;
	}
	
	public static void main(String[] args){
		System.out.println(isPalindrome(1232111));
	}
	
}
