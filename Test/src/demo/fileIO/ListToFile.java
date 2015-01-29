package demo.fileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import basics.BankAccount;

public class ListToFile {
	public static void writeToFile(List<BankAccount> list) throws IOException {
		String file = setFileLocation();
		PrintWriter out = null;

		try {
			// Create a PrintWriter (overwrites file if it exists).
			out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			for (int i = 0; i < list.size(); i++) {
				out.print(list.get(i).getAccountHolder() + ",");
				out.print(list.get(i).getBalance() + "\n");
			}

			System.out.printf("Successfully written text file %s.\n", file);

		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	private static String setFileLocation() throws IOException{
		Scanner sc = new Scanner(System.in);
		String path = "/users/andrew/citi/";
		System.out.println("Enter a filename: ");
		String filename = sc.nextLine();
		return path + filename;
	}

}
