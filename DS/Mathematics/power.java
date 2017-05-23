package Mathematics;

public class power {

	private int pow(int x , int n,int y){
		if(y==1) return x;
		int sum = 0;
		for(int i=0;i<n;i++){
			sum = sum +x;
		}
		return pow(sum,n, y-1);
	}
	
	public static void main(String[] args){
		System.out.println(new power().pow(5,5,4));
	}
}
