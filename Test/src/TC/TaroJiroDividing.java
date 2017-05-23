package TC;

public class TaroJiroDividing {

	public static int getNumber(int A, int B){
		int max = A>B ? A : B;
		int min = A>B ? B : A;
		
		if(max%min!=0) return 0 ;
		if(!isPowerOfTwo(max/min))return 0;
		int count = 1 ; 
		while(min%2==0){
			count++;
			min = min>>1;
		}
		return count;
	}
	
	private static boolean isPowerOfTwo (int x)
	{
	  return (x&(x-1))==0 ? true : false;
	}
	
	public static void main(String[] args){
		System.out.println(TaroJiroDividing.getNumber(8,4));
//		for(int i = 1 ; i < Integer.MAX_VALUE;i++){
//			if(isPowerOfTwo(i)){
//			System.out.println(i);
//			}
//		}
	}
	
}
