package basics;

public class CurrentAccount extends BankAccount {

	private double overdraft;

	public CurrentAccount(String name, int account, double bal) {
		super(name, account, bal);
		this.overdraft = 0;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public void withdraw(double amount) {
		if (amount <= this.getAvailableFunds(this.getBalance(),
				this.getOverdraft())) {
			double oldBalance = this.getBalance();
			double newBalance = this.getBalance() - amount;
			this.setBalance(newBalance);
			System.out.println("Withdrawal Succesful...");
			System.out.println(String.format(
					"Old Balance %.2f | New Balance %.2f", oldBalance,
					newBalance));
		} else {
			System.out.println("Insufficient Funds");
		}
	}

	public double getAvailableFunds(double balance, double overdraft) {
		double funds = balance + overdraft;
		return funds;
	}

	public boolean hasOverdraft() {
		if (overdraft > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void disableOverdraft() {
		this.setOverdraft(0);
		if (this.hasOverdraft() == false) {
			System.out.println("Overdraft has been removed for account: "
					+ this.getAccountNumber());
		} else {
			System.out.println("Overdraft has not been removed for account: "
					+ this.getAccountNumber());
			System.out.println("Overdraft limit for this account is: "
					+ this.getOverdraft());
		}

	}

	@Override
	public String toString() {
		String str = String
				.format("Current Account... \n Account Holder: (%s) \n "
						+ "Balance: %.2f \n" + "Available Funds: %.2f",
						super.getAccountHolder(),
						super.getBalance(),
						this.getAvailableFunds(super.getBalance(),
								this.getOverdraft()));
		return str;
	}

}
