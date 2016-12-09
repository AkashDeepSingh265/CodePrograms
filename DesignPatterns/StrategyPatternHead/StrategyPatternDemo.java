package StrategyPatternHead;

//In strategy pattern Define a family of algorithms, encapsulate each one,
// and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.
public class StrategyPatternDemo {

	public static void main(String[] args){
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuark();
		//Here strategy or behaviour is getting changed at run time . We can also create new Flying behaviour and assign to it at run time without changing any class
		//To change a duck’s behavior at runtime, just call the duck’s setter method for that behavior.
		mallard.setFlyingBehaviour(new CannotFly());
		mallard.performFly();
		
	}
}
