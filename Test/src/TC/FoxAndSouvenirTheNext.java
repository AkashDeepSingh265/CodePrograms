package TC;

public class FoxAndSouvenirTheNext {


	public String ableToSplit(int[] value){
		if(value.length%2!=0) return "Impossible";
		int sum =0;
		for(int i = 0; i < value.length ;i++){
			sum +=value[i];
		}
		if(sum%2!=0)return "Impossible";
		if(knapSack(value,value.length-1,0,sum/2)){
			return "Possible";
		}
		return "Impossible";
	}

	private boolean knapSack(int[] value, int index, int count,int sum) {
		if(index<0) return false;
		if(count==(value.length)/2){
			if(sum ==0)return true;
			return false;
		}
		
		return knapSack(value, index-1, count+1, sum-value[index]) || knapSack(value, index-1, count, sum) ;
	}
	
	private boolean knapSackDP(int[] value, int index, int count,int sum) {
		boolean[][] dp = new boolean[value.length+1][sum+1];
		
		for(int ik =0 ;ik < value.length;ik++ ){
			dp[1][value[ik]]= true;
		}
		for(int i = 2 ; i < dp.length;i++){
			for(int j =0 ; j < value.length;j++){
				for(int k =1; k <= sum ; k ++){
					if(k-value[j]>0){
						dp[i][k] |= dp[i-1][k-value[j]];
					}
				}
			}
		}
		
		return dp[value.length/2][sum];
	}
	
	public static void main(String[] args){
		int[] val = {2,3,5,7,11,16};
		// int[] val = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,75};
		System.out.println(new FoxAndSouvenirTheNext().ableToSplit(val));
	}
}
