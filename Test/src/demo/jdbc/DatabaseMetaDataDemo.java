package demo.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataDemo {

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

        // Get database metadata.
        try {
            DatabaseMetaData dbmd = cn.getMetaData();

            System.out.println("Database product name:  " + dbmd.getDatabaseProductName());
            System.out.println("Driver name:            " + dbmd.getDriverName());
            System.out.println("SQL keywords supported: " + dbmd.getSQLKeywords());
            System.out.println("Supports transactions?  " + dbmd.supportsTransactions());
        } catch (SQLException e) {
            System.out.println("Error getting database metadata: " + e);
        }
    }
}
