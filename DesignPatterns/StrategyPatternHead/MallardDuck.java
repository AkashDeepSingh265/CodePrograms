package StrategyPatternHead;

// In strategy pattern strategy is choosen at run time . Here we are choosing quarking behaviour and flyBehaviour at run time . we can set different
// behaviour also for this mallard duck at run time .
public class MallardDuck extends Duck {

	public MallardDuck() { 
		quarkBehaviour = new Quark();
		flyBehaviour = new FlyWithWings();
	}
	@Override
	public void display() {
		System.out.println("I am a mallard duck");
	}

}
