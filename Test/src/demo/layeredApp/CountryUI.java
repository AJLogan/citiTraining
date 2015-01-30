package demo.layeredApp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CountryUI {
	// UI Layer
	public static void main(String[] args) {
		allCountries();
		addCountry();
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

		try {
			Country country = new Country(0, name, capital, population);
			CountryBL bl = new CountryBL();
			bl.addCountry(country);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
