package contacts.databaseinteration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {

	public static Connection setupDB() {
		String jdbcDriver = "com.mysql.jdbc.Driver";
		String databaseUri = "jdbc:mysql://localhost:8889/contactsdb?"
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
	}

	public static ResultSet executeQuery(Connection cn, String query)
			throws SQLException {
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}

	public static void executeUpdate(Connection cn, String query)
			throws SQLException {
		Statement st = cn.createStatement();
		st.executeUpdate(query);
	};
}
