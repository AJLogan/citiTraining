package basics;

import java.util.Scanner;

public class TestBank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Prompt user for bank account, name and opening balance
		System.out.println("Please enter the account holder name: ");
		String name = sc.nextLine();
		System.out.println("Please enter the account number: ");
		int accno = sc.nextInt();
		System.out.println("Please enter the opening balance: ");
		double bal = sc.nextDouble();
//		Create a bank account balance using the paramaterised constructor
		BankAccount ba = new BankAccount(name, accno, bal);
//		Output the name and balance using toString()
		System.out.println(ba.toString());
		System.out.println("Welcome to the bank " + ba.getAccountHolder());
	}

}
