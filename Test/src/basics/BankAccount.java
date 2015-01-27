package basics;

public class BankAccount {
	private String accountHolder;
	private int accountNumber;
	private double balance;
	private static double interest;

	public BankAccount() {
		this.accountHolder = "";
		this.accountNumber = 0;
		this.balance = 0;
	}

	public BankAccount(String accountHolder, int accountNumber, double balance) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}

	public void deposit(double amount) {
		this.balance = balance + amount;
	}

	// overloaded deposit method to deposit a float
	public void deposit(float amount) {
		this.balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}

	public static double getInterest() {
		return interest;
	}

	public static void setInterest(double interest) {
		// Set interest rate globally
		BankAccount.interest = interest;
	}

	public void calcBalanceWithInterest() {
		balance = balance * (1 + interest);
	}

	@Override
	public String toString() {
		String str = String.format(
				"Account Holder (%s) has an Account %s with a balance %.2f",
				accountHolder, accountNumber, balance);
		return str;
	}

	{
		// Initialization block
		System.out.println("Account Created");
		BankAccount.setInterest(0.5);
		System.out.println("Interest Rate Set at " + BankAccount.getInterest());
	}
}
