package StateDesignPatterns;

public class NoDebitCardState implements AtmMachineState {

	@Override
	public void insertDebitCard() {
		System.out.println("Debit Card Inserted....");
	}

	@Override
	public void ejectDebitCard() {
		System.out.println("Debit Card is not there so cannot eject it");
	}

	@Override
	public void enterPinAndWithdrawMoney() {
		System.out.println("No Debit Card in ATM Machine slot, so you cannot enter the pin and withdraw the money...");
	}

}
