package DecoratorPattern;

public class Mocha extends CondinmentDecorator {

	Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		
		return "Mocha ,"+beverage.getDescription();
	}

	@Override
	public int getCost() {
		return 1+beverage.getCost();
	}

}
