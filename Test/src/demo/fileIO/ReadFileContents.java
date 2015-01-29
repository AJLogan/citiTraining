package demo.fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import basics.BankAccount;

public class ReadFileContents {

	public static void main(String[] args) {
		String File = getFile();
		if (fileExists(File)) {
			displayFile(File);
		} else {
			System.out.println("File Not Found");
		}

	}

	private static String getFile() {
		Scanner sc = new Scanner(System.in);
		String path = "/users/andrew/citi/";
		System.out.println("Enter a filename: ");
		String filename = sc.nextLine();
		return path + filename;
	}

	private static boolean fileExists(String fileLocation) {
		File userFile = new File(fileLocation);
		boolean check = false;
		if (userFile.exists()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	
	private static void displayFile(String File){
		System.out.println("File Found");
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(File));
			String line;
			while ((line = in.readLine()) != null) {

				String[] columns = line.split(",");
				String name = columns[0];
				double balance = Double.parseDouble(columns[1]);

				BankAccount account = new BankAccount(name, balance);
				accounts.add(account);
			}
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
				}
			}
		}
		System.out.println("\nCustomers read from text file:");
		for (BankAccount acc : accounts) {
			System.out.printf("%s %.2f \n", acc.getAccountHolder(),
					acc.getBalance());
		}
	}

}
