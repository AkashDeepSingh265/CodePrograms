package StaticInheritance;
//static members are not inherited . Compiler itself find the static variable in parent class 
// super class is initialized before sub class 
class aTest {
	static {
		System.out.println(aTest.k);
		System.out.println("Initalinzing super");
	}
	static int k = 1;
	static {
		System.out.println(k);
	}
	static int test(){
		return 12;
	}
	
}

public class StaticINheritanceUnd  extends aTest{
	//static int k = 2;
	static int test(){
		return 14;
	}
	static {
		System.out.println("intializing");
		//here compiler change the class to atest class itself .
		k=100;
	}
	public static void main(String[] args){
		//here compiler change the class to atest class itself .
		//System.out.println(StaticINheritanceUnd.k);
		System.out.println("Entering class");
		System.out.println(aTest.k);
	}
}
