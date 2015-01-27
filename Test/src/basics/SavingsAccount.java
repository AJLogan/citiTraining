package basics;

public class SavingsAccount extends BankAccount {
	
	public SavingsAccount(String name, int account, double bal){
		super(name, account, bal);
	}
	
	@Override
	public String toString() {
		String str = String.format(
				"Savings Account... \n Account Holder (%s) has an Account %s with a balance %.2f", super.getAccountHolder(), super.getAccountNumber(), super.getBalance());
		return str;
	}
	
	public void saverBonus(double bonus){
		deposit(bonus);
	}
}
