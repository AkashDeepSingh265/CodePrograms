package Mathematics;

public class NewtonMethodReciproccal {

	public static void reciprocal(int num , int precision,double x){
		double tolerance = Math.pow(.1, precision);
		double nexX;
		double err=1;
		
		while(err > tolerance){
			nexX = x*(2-num*x);
			err = Math.abs((nexX-x)/x);
			x = nexX;
		}
	System.out.println("Reciprocal of" + num + "is :" +x);	
	}

	public static void main(String[] args){
		for(int i = 1 ; i < 100;i++){
			
			NewtonMethodReciproccal.reciprocal(i,10,.3);
		}
		
	}
}
