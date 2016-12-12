
public class RecursiveMultiply {

	public static int getValue(int a,int b){
//		if(a<0&&b<0){
//			if(a>b){
//				return multiplyRecursively(-b,-a);
//			}else{
//				return multiplyRecursively(-a,-b);
//			}
//		}
//		if(a<0){
//			
//		}
		if(a>b){
			return multiplyRecursively(a,b);
		}else{
			return multiplyRecursively(b,a);
		}
	}

	private static int multiplyRecursively(int a, int b) {
		if(b==0)
			return 0;
		return a + multiplyRecursively(a, b-1);
	}
	
	public static void main(String[] args){
		System.out.println(getValue(5, 3));
	}
}
