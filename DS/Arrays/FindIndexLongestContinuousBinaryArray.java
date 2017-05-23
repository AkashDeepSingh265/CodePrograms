package Arrays;

public class FindIndexLongestContinuousBinaryArray {

	public static int findIndex(int[] bin){
		int cur,prev_zero,length,maxLength;
		cur=0;
		prev_zero=-1;
		maxLength=0;
		length=0;
		int index=-1;
		while(cur<bin.length){
			while(cur<bin.length&&bin[cur]==1){
				length++;
				cur++;
			}
			if(length>maxLength){
				maxLength = length;
				if(prev_zero>=0){
				index=prev_zero;
				}else{
					index=cur;
				}
			}
			if(cur<bin.length-1&&bin[cur+1]==1){
//				if(length>maxLength){
//					maxLength = length;
//				}
				if(prev_zero>=0){
					length = cur-prev_zero;
				}else{
					length++;
				}
				prev_zero=cur;
				cur++;
			}
			while(cur<bin.length&&bin[cur]==0){
				prev_zero=cur;
				length=1;
				cur++;
				
			}
			
		}
		return index;
	}
	public static void main(String[] args){
		int[] input = {1,1,1,1,1,1,0,0,0,0,0,1,1,1};
		System.out.println(FindIndexLongestContinuousBinaryArray.findIndex(input));
		
	}
}
