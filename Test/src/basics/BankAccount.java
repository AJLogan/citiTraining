package basics;

public class BankAccount {
	private int accountNumber;
	private double balance;
	
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
	
//	overloaded deposit method to deposit a float
	public void deposit(float balance){
		this.balance = balance + balance;
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
	}
}
