package package3;

class Animal {
	
	static int val = 111;
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}
public class Cat extends Animal {
	static int val = 123;
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        //myCat.testClassMethod();
       // Animal.testClassMethod();
       // myAnimal.testInstanceMethod();
        System.out.println(myCat.val);
        System.out.println(myAnimal.val);
        
    }
}
