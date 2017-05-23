package CF;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class MovieBestMoments {

	public void compute(){
		Scanner in = null;
		try{
			in = new Scanner(new BufferedInputStream(System.in));
			int numOfMoments = in.nextInt();
			int forwardMin = in.nextInt();
			int curTime = 1;
			int startTime;
			int endTime;
			int diff;
			int steps;
			int result=0;
			while(numOfMoments>0){
				startTime = in.nextInt();
				endTime = in.nextInt();
				diff = startTime - curTime;
				steps =diff/forwardMin; 
				if(steps>=1){
					curTime = curTime + steps*forwardMin;
					result = result + endTime-curTime +1;
					curTime = endTime+1;
				}else{
					result = result + endTime - curTime+1;
					curTime = endTime +1;
				}
				
				numOfMoments--;
			}
			System.out.println(result);
		}finally{
			in.close();
		}
	}
	public static void main(String[] args) {
		new MovieBestMoments().compute();
	}

}
