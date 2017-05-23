package ClassDeclerations;
//1 .private variabes are accesible in that class only . str of test2 class cannot be accesed from 
//test1 class
// 2. files with no public classes can have name that doesnot matvh any of the classes in file 
//3. For classes only public , abstract , final acess modifiers are permitted 
  class  test1 {
	 private String str = "Test1 nonpublic";
	 public static void main(String[] args){
		 System.out.println(new test1().str);
		// System.out.println(new test2().str); compile error
	 }
}
 
 class test2 {
	 private String str = "Test2";
	 public static void main(String[] args){
		 System.out.println(new test2().str);
	 }
}

 class test3{
	 private String str = "Test3";
 }