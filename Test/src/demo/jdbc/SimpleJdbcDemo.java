package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleJdbcDemo {

	public static void main(String[] args) {

		// Use database name if provided, else use the demo Derby database.
		String dbName;
		if (args.length == 1) {
			dbName = args[0];
		} else {
			dbName = "jdbc:mysql://localhost:8889/javaDemoDB?"
					+ "user=root&password=root";
		}

		// Load Derby driver.
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading JDBC/ODBC driver: " + e);
		}

		// Connect to a database.
		Connection cnEmps = null;
		try {
			cnEmps = DriverManager.getConnection(dbName);
			System.out.println("Hooray!");
		} catch (SQLException e) {
			System.out.println("Error connecting to a database: " + e);
		}

	}
}
