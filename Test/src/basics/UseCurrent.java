package basics;

public class UseCurrent {

	public static void main(String[] args) {
		CurrentAccount ca = new CurrentAccount("CA 1", 12345, 1.50);
		ca.hasOverdraft();
		System.out.println(ca.toString());
		ca.setOverdraft(1);
		ca.hasOverdraft();
		System.out.println(ca.toString());
		System.out.println("\n");
		ca.deposit(10);
		System.out.println(ca.toString());
		ca.withdraw(12.51);
		System.out.println(ca.toString());
		ca.withdraw(12.50);
		System.out.println(ca.toString());
		ca.deposit(1);
		ca.disableOverdraft();
		System.out.println(ca.toString());
	}
}
