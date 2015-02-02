package demo.layeredApp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CountryUI {
	// UI Layer
	public static void main(String[] args) throws SQLException {
		 allCountries();
		// addCountry();
		// allCountries();
		editCountry();
		allCountries();
		deleteCountry();
		allCountries();
	
	}

	public static void allCountries() {
		List<Country> countries = null;
		try {
			CountryBL bl = new CountryBL();
			countries = bl.getCountries();
			for (Country c : countries) {
				System.out.println(c.toString());
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addCountry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Country: ");
		String name = sc.nextLine();
		System.out.println("Enter Capital: ");
		String capital = sc.nextLine();
		System.out.println("Enter Population: ");
		long population = sc.nextLong();
		sc.close();

		try {
			Country country = new Country(0, name, capital, population);
			CountryBL bl = new CountryBL();
			bl.addCountry(country);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void editCountry() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Country would you like to edit?");
		String name = sc.nextLine();
		try {
			CountryBL bl = new CountryBL();
			Country c = bl.getCountryByName(name);
			if (c != null) {
				System.out.println("Current Information: ");
				System.out.println("Name: " + c.getName());
				System.out.println("Capital: " + c.getCapital());
				System.out.println("Population: " + c.getPopulation());

				System.out.println("Which data would you like to edit?");
				System.out.println("(N)ame, (C)apital, (P)opulation");
				String param = sc.next();
				System.out.println(param);
				if (param.equals("N") | param.equals("n")) {
					try {
						bl.editName(c);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} else if (param.equals("C") | param.equals("c")) {
					try {
						bl.editCapital(c);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} else if (param.equals("P") | param.equals("p")) {
					try {
						bl.editPopulation(c);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Invalid Entry");
				}
			} else {
				System.out.println("No Country with that name");

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void deleteCountry() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Country would you like to delete?");
		String name = sc.nextLine();
		try {
			CountryBL bl = new CountryBL();
			Country c = bl.getCountryByName(name);
			if (c != null) {
				System.out.println("Are you sure (Y/N");
				String confirmation = sc.nextLine();
				if (confirmation.equals("Y") | confirmation.equals("y")){
					bl.deleteCountry(c);
				}
				else {
					System.out.println("Canceled");
				}
			} else {
				System.out.println("No Country with that name");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
