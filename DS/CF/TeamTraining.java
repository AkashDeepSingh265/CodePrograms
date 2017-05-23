package CF;

import java.util.Scanner;

public class TeamTraining {

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int res = 0 ;
		while(n>0 && m >0){
			
			if(n>m){
				n -=2;
				m -=1;
				if(n<0) {
					System.out.println(res);
					return;
				}
			}else{
				m-=2;
				n-=1;
				if(m<0){
					System.out.println(res);
					return;
				}
			}
		res++;
		}
	System.out.println(res);
	}
	
}
