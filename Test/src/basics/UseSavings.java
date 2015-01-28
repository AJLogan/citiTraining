package basics;

public class UseSavings {

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount("SA 1", 12345, 1.50);
		System.out.println(sa.toString());
		System.out.println("\n");
		sa.deposit(1000);
		sa.saverBonus(100);
		System.out.println(sa.toString());
		BankAccount[] accounts = {
				new SavingsAccount("Account 1", 12345678, 0),
				new BankAccount("Account 2", 98752526, 0), //Note that the BankAccount toString is used below...
				new SavingsAccount("Account 3", 28476590, 0),
				new CurrentAccount("CA 1", 12345, 1.50)
		};
		
		accounts[3].deposit(100);
		
		for (BankAccount ac : accounts){
			System.out.println(ac.toString());
		}	
	}
}
