package package2;

import package1.SuperClass;

//for subclass out side the package protected members can be accesed only by inheritance
//protected members cannot be accesed by reference for subclasses outside the package 
public class subclass extends SuperClass {

	public static void main(String[] args){
		System.out.println(new subclass().x);
	}
}
