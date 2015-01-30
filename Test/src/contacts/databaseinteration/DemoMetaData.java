package contacts.databaseinteration;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoMetaData {

	public static void main(String[] args) {
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
		try {
			DatabaseMetaData md = cn.getMetaData();
			System.out.println(md.getDatabaseProductName());
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM COUNTRY");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println(rsmd.getColumnName(i) + " "
						+ rsmd.getColumnTypeName(i));
			}
			if (md.supportsBatchUpdates()){
				cn.setAutoCommit(false);
				Statement batchStmnt = cn.createStatement();
				batchStmnt.addBatch("INSERT INTO country(name, capital, population) "
						+ "VALUES ('Nigeria', 'Lagos', 190000);");
				batchStmnt.addBatch("INSERT INTO country(name, capital, population) "
						+ "VALUES ('Cuba', 'Havana', 1000);");
				batchStmnt.addBatch("INSERT INTO country(name, capital, population) "
						+ "VALUES ('Maroco', 'Marakesh', 12394);");
				batchStmnt.addBatch("INSERT INTO country(name, capital, population) "
						+ "VALUES ('Argentina', 'Dont Cry For Me', 1676790000);");
				int[] numrows = batchStmnt.executeBatch();
				cn.commit();
				cn.setAutoCommit(true);
			}
			rs.next();
			rs.last();
			System.out.println("Last Country is: " + rs.getString("name"));
			rs.first();
			System.out.println("First Country is: " + rs.getString("name"));
			// rs.updateString("name", "Belgium");
			rs.updateRow();

		} catch (SQLException e) {
			System.out.println("Error From DB: " + e);
		}

	}

}
