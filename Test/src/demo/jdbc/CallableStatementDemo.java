package demo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {

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

        // Call a stored procedure.
        try {
            CallableStatement cs = cn.prepareCall(
                    "{? = call getRegionInfo(?,?) }");

            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, "Wales");
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.execute();

            System.out.println("Number of emps in Wales: " + cs.getInt(1));
            System.out.println("Average salary is £" + cs.getBigDecimal(3));
        } catch (SQLException e) {
            System.out.println("Error executing INSERT, DELETE, or UPDATE statement: " + e);
        }
    }
}
