import java.util.Random;


public class RandomNumber {

	private int[][] numbers = {
			{1,2,3,4,5},
			{6,7,1,2,3},
			{4,5,6,7,1},
			{2,3,4,5,6},
			{7,0,0,0,0}
	};
	
	private int generateRandom(){
		int result=0;
		while(result==0){
			Random rand = new Random();
		    int i = rand.nextInt(5) + 1;
		    int j = rand.nextInt(5) + 1;
			result = numbers[i-1][j-1];
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] count = {0,0,0,0,0,0,0,0};
		RandomNumber randNum = new RandomNumber();
		int num;
		for(int i=0;i<700;i++){
			num = randNum.generateRandom();
			count[num]++;
		}
		for(int i=1;i<8;i++){
			System.out.println(i+":"+count[i]);
		}
	}
}
