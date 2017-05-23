package package1;

public class StaticInitialization {

	static int i = 10;
	static {
		System.out.println(i);
		i=5;
		System.out.println(i);
	}
	
	
	public static void main(String[] args){
		System.out.println(i);
	}
}
