package demo.layeredApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contacts.databaseinteration.DatabaseUtils;

public class CountryDAL {
	// Data Access Layer

	/*
	 * Database Connection Parameters
	 */
	private static String strConn = "jdbc:mysql://localhost:8889/contactsdb?user=root&password=root";
	private static String strDriver = "com.mysql.jdbc.Driver";

	// Set up Database connection and return a connection
	private static Connection setDBConnection() {
		// Load JDBC Driver
		try {
			Class.forName(strDriver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading JDBC driver: " + e);
		}

		// Connect to a database.
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(strConn);
		} catch (SQLException e) {
			System.out.println("Error connecting to a database: " + e);
		}
		return cn;
	}

	// CRUD Operations
	// CREATE
	static int addCountry(Country c) throws SQLException {
		int ret = 0;
		String addCountry = "INSERT INTO country(name, capital, population) "
				+ "VALUES(?,?,?)";

		Connection cn = setDBConnection();
		try {
			PreparedStatement st = cn.prepareStatement(addCountry);
			st.setString(1, c.getName());
			st.setString(2, c.getCapital());
			st.setLong(3, c.getPopulation());
			ret = st.executeUpdate();
			return ret;
		} catch (SQLException e) {
			throw e;
		}

	}

	// READ
	static List<Country> allCountries() throws SQLException {
		List<Country> countries = new ArrayList<Country>();

		String getCountries = "SELECT country_id, name, capital, population FROM COUNTRY";

		Connection cn = setDBConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(getCountries);
			while (rs.next()) {
				countries.add(new Country(rs.getInt("country_id"), rs
						.getString("name"), rs.getString("capital"), rs
						.getLong("population")));
			}
			return countries;

		} catch (SQLException e) {
			throw e;
		}
	}

	// TODO IMPLEMENT UPDATE AND DELETE

	// // UPDATE
	static boolean editPopulation(Country c) throws SQLException {
		boolean ret = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("What country do you want to update?: ");
		String countryInQuestion = sc.next();

		System.out
				.println("Enter the new information for " + countryInQuestion);
		System.out.println("Enter New Population: ");
		long population = sc.nextLong();

		String updatePopulationQuery = "UPDATE country "
				+ "set population = ? " + "WHERE name like '"
				+ countryInQuestion + "';";

		Connection cn = setDBConnection();
		try {
			PreparedStatement ps = cn.prepareStatement(updatePopulationQuery);
			ps.setLong(0, population);
			ret = ps.execute();
			return ret;
		} catch (SQLException e) {
			throw e;
		}
	}
	//
	// // DELETE
	// static void deleteCountry(Country c) {
	//
	// }
}
