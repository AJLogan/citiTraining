package ibmLayeredApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		System.out.println("Welcome to Andrew's Console App.");
		System.out
				.println("Database Configuration is set at top of DataAccess.java");
		System.out
				.println("File output path is set in setFileLocation() in DataAccess.java");
		System.out.println("");
		runMenu();
	}

	private static void runMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose from the following options");
		System.out.println("1 - Run Report 1.");
		System.out.println("Type EXIT to close the app");
		String selection = sc.nextLine();
		if (selection.equals("1")) {
			System.out.println("You Selected: 1");
			System.out.println("Run Report 1.");
			System.out.println("");
			try {
				runReport1();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			runMenu();
		} else if (selection.equals("EXIT") | selection.equals("exit")
				| selection.equals("Exit")) {
			System.out.println("Goodbye");
			return;
		} else {
			System.out.println("Invalid option...");
			runMenu();
		}
	}

	private static void runReport1() throws SQLException, IOException {
		BusinessLayer bl = new BusinessLayer();
		List<IBM> data = new ArrayList<IBM>();
		List<Report1b> data2 = new ArrayList<Report1b>();
		data = bl.getReport1aData();
		data2 = bl.getReport2Data();
		bl.writeReportToFile(data, data2);
	}
}
