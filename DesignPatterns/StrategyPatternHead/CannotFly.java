package StrategyPatternHead;

public class CannotFly implements FlyingBehaviour{

	@Override
	public void fly() {
		System.out.println("I am not designed to fly");
	}

}
