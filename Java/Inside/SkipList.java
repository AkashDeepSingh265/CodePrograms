package Inside;

public class SkipList {

	public static int getNoOfPaths(int[] numbers){
		int n = numbers.length ;
		int[] path = new int[n];
		path[n-1] =1 ;
		int max;
		for(int i = n-2;i>=0;i--){
			max = path[i+1];
				if(numbers[i]!=1&&i+numbers[i]<=n-1){
					max =max+ path[i+numbers[i]];
				}
			path[i]=max;
		}
		return path[0]-1;
	}
	public static void main(String[] args){
		int[] ar = {8,3,2,1,4,3,2,4,5};
		System.out.println(SkipList.getNoOfPaths(ar));
	}
}
