package DecoratorPattern;

//Decorator pattern achieves a single objective of dynamically adding responsibilities to any object.
public class StarBuzzCofeeDecoratorDemo {

	public static void main(String[] args){
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription()+ " $" + beverage.getCost());
		beverage = new Mocha(beverage);
		beverage = new Whip(beverage);
		System.out.println(beverage.getDescription()+ " $" + beverage.getCost());
	}
}
