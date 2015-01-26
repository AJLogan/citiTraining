package basics;
import java.util.Scanner;

public class UseBank {

	public static void main(String[] args) {
		System.out.println("Enter account number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter opening Balance: ");
		BankAccount ba = new BankAccount();
		ba.accountNumber = n;
		ba.balance = sc.nextDouble();
	
		
		System.out.println(n + " cubed is " + myCube(n));
		System.out.println(n + " = " + n); //Primitives passed by value so do not change when used in methods
		
		System.out.println("Bank Account balance has changed...");
		System.out.println("Account Number: " + ba.accountNumber);
		System.out.println("Old Balance: " + ba.balance + " | New Balance: " + setBalance(ba));
		
		System.out.println("ba.balance = " + ba.balance); //reference types are passed by reference so do change when used in methods
		
		sc.close();
	}
	
	private static int myCube(int n){
		n = n*n*n;
		return n;
	}
	
	private static double setBalance(BankAccount ba){
		ba.balance += 100;
		return ba.balance;
	}
}
