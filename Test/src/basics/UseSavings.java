package basics;

public class UseSavings {

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount("SA 1", 12345, 1.50);
		System.out.println(sa.toString());
		sa.deposit(100);
		System.out.println(sa.toString());
		BankAccount[] accounts = {
				new SavingsAccount("Account 1", 12345678, 10.99),
				new BankAccount("Account 2", 98752526, 99.00), //Note that the BankAccount toString is used below...
				new SavingsAccount("Account 3", 28476590, 882.00)
		};
		
		for (BankAccount ac : accounts){
			System.out.println(ac.toString());
		}
			
	}
}
