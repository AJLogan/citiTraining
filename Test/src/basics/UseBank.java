package basics;
import java.util.Scanner;

public class UseBank {

	public static void main(String[] args) {
		System.out.println("Enter account number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter opening Balance: ");
//		ba.setAccountNumber(n);
		double balance = sc.nextDouble();
		BankAccount ba = new BankAccount("Test", n, balance);
//		BankAccount ba = new BankAccount(); << Default Constructor Usage >>
		
//		System.out.println(n + " cubed is " + myCube(n));
//		System.out.println(n + " = " + n); //Primitives passed by value so do not change when used in methods
		
		System.out.println("Bank Account balance has changed...");
		
		System.out.println("Account Number: " + ba.getAccountNumber());
		System.out.println("Old Balance: " + ba.getBalance());
		setBalance(ba);
		System.out.println("New Balance: " + ba.getBalance());
		
		System.out.println("ba.balance = " + ba.getBalance()); //reference types are passed by reference so do change when used in methods
		
		sc.close();
		
		System.out.println(ba.toString());
		
		ba.withdraw(100);
		System.out.println("ba.balance = " + ba.getBalance()); //reference types are passed by reference so do change when used in methods
	}
	
//	private static int myCube(int n){
//		n = n*n*n;
//		return n;
//	}
	
	private static double setBalance(BankAccount ba){
		ba.deposit(100);
		return ba.getBalance();
	}
}
