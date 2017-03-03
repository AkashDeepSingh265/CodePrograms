
public class MultiplyWithBitWiseOperator {

	public static int multiplyBitwise(int a , int b){
		int num = 0;
		int count=0;
		while(b>0){
			if(b%2==1){
				num=num + (a<<count);
			}
			count++;
			b=b>>1;
		}
		return num;
	}
	
	public static void main(String[] args){
		System.out.println(multiplyBitwise(21,17));
	}
}
