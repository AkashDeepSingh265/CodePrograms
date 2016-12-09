package StateDesignPatterns;

public class HasDebitCardState implements AtmMachineState {

	@Override
	public void insertDebitCard() {
		System.out.println("Debit Card alredy there cannot insert it again");
	}

	@Override
	public void ejectDebitCard() {
		System.out.println("Debit Card is ejected...");
	}

	@Override
	public void enterPinAndWithdrawMoney() {
		System.out.println("Pin number has been entered correctly and money has been withdrawn...");
	}

}
