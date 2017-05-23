package package1;

//1. Super() should be the first statement in constructor 
//2. only static variables or members can be accesed while calling Super(). Instance variables
//  cannot be used .
// 
public class FinalTest extends SuperClass{
	//private final SuperClass parent = new SuperClass();
	private int val ;
	public FinalTest(){
		System.out.println("inside no arg constructor ");
	}
	
	public FinalTest(int a,int b ){
		super();
		System.out.println("inside arg ");
	}
	public static void main(String[] args){
		new FinalTest(1,2);
		
		FinalTest f = (FinalTest) new SuperClass();
	}
}
