package demo.collections;

import java.util.*;

import basics.*;

public class ListDemo {
	public static void main(String[] args) {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Accounts?: ");
		n = sc.nextInt();
		String ac = "";
		int accno = 0;
		double bal = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Account Holder: ");
			ac = sc.next();
			System.out.println("Account Number: ");
			accno = sc.nextInt();
			System.out.println("Account Balance: ");
			bal = sc.nextDouble();
			accounts.add(new BankAccount(ac, accno, bal));
		}
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i));
		}
	}
}
