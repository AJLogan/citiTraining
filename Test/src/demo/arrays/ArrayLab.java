package demo.arrays;

import basics.BankAccount;

public class ArrayLab {

	public static void main(String[] args) {
		BankAccount[] accounts = {
				new BankAccount("Andrew Logan", 41417041, 10000.50),
				new BankAccount("Steve Jobs", 5151041, 10.50),
				new BankAccount("Ryan Cash", 78787041, 980.50),
				new BankAccount("Bob Dylan", 47658041, 9872.50) };
//		Write code to output the average balance and the name and balance of the account holder with the most money
		getBiggestBalance(accounts);
		getAverageBalance(accounts);
	}
	
	public static void getBiggestBalance(BankAccount[] arr){
		double bal = 0;
		int index = 0;
		for (int i = 0; i< arr.length; i++){
			if (arr[i].getBalance() > bal){
				bal = arr[i].getBalance();
				index = i;
			}
		}
		System.out.println("Account with largest balance...");
		System.out.println(arr[index].getAccountHolder() + " " + arr[index].getBalance());
	}
	
	public static void getAverageBalance(BankAccount[] arr){
		double bal = 0;
		double average = 0;
		for (int i = 0; i< arr.length; i++){
			bal = bal + arr[i].getBalance();
			}	
		average = bal / arr.length;
		System.out.println("Average Balance...");
		System.out.println(average);
	}
}