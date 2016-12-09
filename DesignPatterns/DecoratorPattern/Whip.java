package DecoratorPattern;

public class Whip extends CondinmentDecorator {

	Beverage beverage;
	
	public Whip(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		
		return "Whip ,"+beverage.getDescription();
	}

	@Override
	public int getCost() {
		return 2+beverage.getCost();
	}

}
