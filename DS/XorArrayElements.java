
public class XorArrayElements {

	
	public static void main(String[] args){
		int xor = 0,xorAry = 0 ;
		int[] ary = {1,2,4,5,6,7,8};
		for(int i=1;i<9;i++){
			xor = xor^i;
		}
		for(int i=0;i<ary.length;i++){
			xorAry = xorAry^ary[i];
		}
		System.out.println(xor^xorAry);
	}
}
