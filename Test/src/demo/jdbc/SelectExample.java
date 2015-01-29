package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectExample {

	public static void main(String[] args) throws SQLException {
		ResultSet rs = null;
		try {
			rs = executeQuery(setupDB(), getParameter());
			while (rs.next() != false) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String title = rs.getString("title");
				System.out.println(firstname + " " + lastname + "\n  " + title);
			}
		} catch (SQLException e) {
			System.out.println("Error executing SELECT statement: " + e);
		}
	}

	private static String getParameter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the city you would like to query: ");
		String city = sc.next();
		sc.close();
		return city;
	}

	private static ResultSet executeQuery(Connection cn, String variable)
			throws SQLException {
		Statement st = cn.createStatement();
		String query = "SELECT firstname, lastname, title"
				+ " FROM person p JOIN employee e" + " ON p.id = e.id"
				+ " WHERE city = '" + variable + "';";
		ResultSet rs = st.executeQuery(query);
		return rs;

	};

	private static Connection setupDB() {
		String jdbcDriver = "com.mysql.jdbc.Driver";
		String databaseUri = "jdbc:mysql://localhost:8889/classfiles?"
				+ "user=root&password=root";

		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading JDBC driver: " + e);
		}

		// Connect to a database.
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(databaseUri);
		} catch (SQLException e) {
			System.out.println("Error connecting to a database: " + e);
		}
		return cn;
	};
}