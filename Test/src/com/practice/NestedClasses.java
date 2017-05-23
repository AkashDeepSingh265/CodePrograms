package com.practice;

public class NestedClasses {
	private int a=3;
	private static  String owner;
	private int  noOfObjectsInner=0;
	public NestedClasses() {
		System.out.println("creating nested class object");
		this.owner="Akash";
	}
	
	private  String getOwner(){
		return owner;
	}
	
	
	private static class innerClass{
		private int b;
		private int nosOfObjects=0;
		public innerClass(int val) {
			System.out.println("Inside inner class ");
			nosOfObjects++;
			//getOwner();
			//noOfObjectsInner++;
			this.b=val;
		}
		public int getMathRandom(){
			return (int)Math.random()*1000;
		}
	}
	
	public static void main(String[] args){
		NestedClasses nesObj = new NestedClasses();
		NestedClasses nesObj1 = new NestedClasses();
		NestedClasses nesObj2 = new NestedClasses();
		new NestedClasses.innerClass(1);
		NestedClasses.innerClass innerObj =nesObj.new innerClass(5); 
		System.out.println(innerObj.nosOfObjects);
		NestedClasses.innerClass innerObj2 =nesObj.new innerClass(5); 
		System.out.println(innerObj2.nosOfObjects);
//		NestedClasses.innerClass innerObj1 =new NestedClasses.innerClass(6);
//		System.out.println(innerObj.nosOfObjects);
//		NestedClasses.innerClass innerObj2 =new NestedClasses.innerClass(7);
//		System.out.println(innerObj.nosOfObjects);
		System.out.println("total objects "+ nesObj.noOfObjectsInner);
	}
}
