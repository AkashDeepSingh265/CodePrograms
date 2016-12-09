package StrategyPatternHead;

public abstract class Duck {

	FlyingBehaviour flyBehaviour;
	QuarkBehaviour quarkBehaviour;
	
	public void swim(){
		System.out.println("Swimming");
	}
	
	public abstract void display();
	
	public void performFly(){
		flyBehaviour.fly();
	}
	public void performQuark(){
		quarkBehaviour.quark();
	}
	
	public void setFlyingBehaviour(FlyingBehaviour flyingBehaviour){
		this.flyBehaviour = flyingBehaviour;
	}
	
	public void setQuarkBehaviour(QuarkBehaviour quarkBehaviour){
		this.quarkBehaviour = quarkBehaviour;
	}
}
