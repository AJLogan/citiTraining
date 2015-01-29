package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {

    public static void main(String[] args) {
        
        // Set up a default JDBC driver and database name.
    	String jdbcDriver = "com.mysql.jdbc.Driver";
        String databaseUri = "jdbc:mysql://localhost:8889/javaDemoDB?"
							+ "user=root&password=root";

        // Load JDBC driver.
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

        // Execute a query and get resultset metadata.
        try {
            Statement st = cn.createStatement();

            ResultSet rsEmps = st.executeQuery("SELECT * FROM Employees");
            ResultSetMetaData rsmd = rsEmps.getMetaData();

            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Col name: " + rsmd.getColumnName(i));
                System.out.println("Type: "     + rsmd.getColumnTypeName(i));
                System.out.println("Nullable? " + rsmd.isNullable(i));
            }
        } catch (SQLException e) {
            System.out.println("Error getting resultset metadata: " + e);
        }
    }
}
