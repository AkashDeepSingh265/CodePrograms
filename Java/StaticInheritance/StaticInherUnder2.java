package StaticInheritance;
//static members are not inherited 
class abc {
	static int ab = 1;
	static int test(){
		return 12;
	}
}

public class StaticInherUnder2 extends abc{
	int ab = 1;
	
	static int test(){
		return 14;
	}
	public static void main(String[] args){
		//here compiler searches for ab in class so it found ab as instance variable and hence gives compile time error 
		//System.out.println(ab);
		System.out.println(test());
	}
}
