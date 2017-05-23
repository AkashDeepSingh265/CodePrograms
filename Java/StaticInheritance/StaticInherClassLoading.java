package StaticInheritance;

import javax.management.RuntimeErrorException;

import BfsDfs.Node;

//class is initialized when its field is used for first time 
class sa{
	static int a = 1;
	 public void f(){
		 throw new Exception();
	}
}

class sb extends sa{
	static int b = 23;
	static{
		System.out.println("Initializng class sb");
		a=10;
	}
	 void f(){
		
	}
}

public class StaticInherClassLoading {

	public static void main(String[]  args){
		//here comiper changes to sa.a so class sb is not initialized
		System.out.println(sb.a);
		
		//Here class sb is initialized
		System.out.println(sb.b);
		
	}
}
