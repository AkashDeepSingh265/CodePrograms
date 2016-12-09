package DecoratorPattern;

public class HouseBlend extends Beverage{

	public HouseBlend() {
		description = "HouseBlend";
	}

	public int getCost() {
		return 2;
	}

}
