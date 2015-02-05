package demo.layered;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	static Country getCountryByID(int id) throws SQLException {
		Country country = null;
		String getCountry = "SELECT country_id, name, capital, population FROM COUNTRY where country_id = '"
				+ id + "';";
		Connection cn = setDBConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(getCountry);
			if (rs.next()) {
				int country_id = rs.getInt("country_id");
				String name = rs.getString("name");
				String capital = rs.getString("capital");
				Long population = rs.getLong("population");
				country = new Country(country_id, name, capital, population);
			}
			return country;
		} catch (SQLException e) {
			throw e;
		}
	}

	static Country getCountryByName(String param) throws SQLException {
		Country country = null;
		String getCountry = "SELECT country_id, name, capital, population FROM COUNTRY where name = '"
				+ param + "';";
		Connection cn = setDBConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(getCountry);
			if (rs.next()) {
				int country_id = rs.getInt("country_id");
				String name = rs.getString("name");
				String capital = rs.getString("capital");
				Long population = rs.getLong("population");
				country = new Country(country_id, name, capital, population);
			}
			return country;
		} catch (SQLException e) {
			throw e;
		}
	}

	// UPDATE
	static boolean editName(Country c) throws SQLException {
		boolean ret = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter New Name: ");
		String newName = sc.next();
		sc.close();
		String updateNameQuery = "UPDATE country " + "SET country_id = "
				+ c.getId() + ", " + "name = '" + newName + "', "
				+ "capital = '" + c.getCapital() + "', " + "population = "
				+ c.getPopulation() + " " + "WHERE country_id = " + c.getId()
				+ ";";

		Connection cn = setDBConnection();
		try {
			PreparedStatement ps = cn.prepareStatement(updateNameQuery);
			ret = ps.execute();
			return ret;
		} catch (SQLException e) {
			throw e;
		}
	}

	static boolean editCapital(Country c) throws SQLException {
		boolean ret = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter New Name: ");
		String newCapital = sc.next();
		sc.close();
		String updateCapitalQuery = "UPDATE country " + "SET country_id = "
				+ c.getId() + ", " + "name = '" + c.getName() + "', "
				+ "capital = '" + newCapital + "', " + "population = "
				+ c.getPopulation() + " " + "WHERE country_id = " + c.getId()
				+ ";";

		Connection cn = setDBConnection();
		try {
			PreparedStatement ps = cn.prepareStatement(updateCapitalQuery);
			ret = ps.execute();
			return ret;
		} catch (SQLException e) {
			throw e;
		}
	}

	static boolean editPopulation(Country c) throws SQLException {
		boolean ret = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter New Population: ");
		long newPopulation = sc.nextLong();
		sc.close();
		String updatePopulationQuery = "UPDATE country " + "SET country_id = "
				+ c.getId() + ", " + "name = '" + c.getName() + "', "
				+ "capital = '" + c.getCapital() + "', " + "population = "
				+ newPopulation + " " + "WHERE country_id = " + c.getId() + ";";

		Connection cn = setDBConnection();
		try {
			PreparedStatement ps = cn.prepareStatement(updatePopulationQuery);
			ret = ps.execute();
			return ret;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	static boolean editCountry(Country c) throws SQLException {
		boolean ret = true;
		String updateCountryQuery = "UPDATE country " + "SET country_id = "
				+ c.getId() + ", " + "name = '" + c.getName() + "', "
				+ "capital = '" + c.getCapital() + "', " + "population = "
				+ c.getPopulation() + " " + "WHERE country_id = " + c.getId() + ";";

		Connection cn = setDBConnection();
		try {
			PreparedStatement ps = cn.prepareStatement(updateCountryQuery);
			ret = ps.execute();
			return ret;
		} catch (SQLException e) {
			throw e;
		}
	}

	// DELETE
	static boolean deleteCountry(Country c) throws SQLException {
		boolean ret = true;

		String deleteCountry = "DELETE FROM Country WHERE country_id = "
				+ c.getId() + ";";

		Connection cn = setDBConnection();
		try {
			PreparedStatement ps = cn.prepareStatement(deleteCountry);
			ret = ps.execute();
			return ret;
		} catch (SQLException e) {
			throw e;
		}
	}
}
