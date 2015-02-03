package ibmLayeredApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DataAccess {
	/*
	 * Database Connection Parameters
	 */
	// THIS WILL BE DIFFERENT CONNECTION THAT ON THE VIRTUAL MACHINE
	private static String strConn = "jdbc:mysql://localhost:8889/classfiles?user=root&password=root";
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

	// Setup File IO
	static boolean writeReportToFile(List<IBM> list, List<Report1b> list2)
			throws IOException {
		String file = setFileLocation();
		PrintWriter out = null;

		try {
			// Create a PrintWriter (overwrites file if it exists).
			out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			out.println("Report Created at: " + dateFormat.format(date) + "\n");
			for (int i = 0; i < list.size(); i++) {
				out.print("Date: " + list.get(i).getTdate() + "\n");
				out.print("Lowest Opening Price: " + list.get(i).getOpenpr()
						+ "\n");
				out.print("Highest Closing Price: " + list.get(i).getClosepr());
				out.println("\n");
			}
			out.print("Date\t\tMaxTime\t\tMaxPrice\tMinTime\t\tMinPrice \n");
			for (int i = 0; i < list2.size(); i++) {
				out.print(list2.get(i).getTdate() + "\t");
				out.print(list2.get(i).getMax_time() + "\t");
				out.print(list2.get(i).getMax_price() + "\t\t");
				out.print(list2.get(i).getMin_time() + "\t");
				out.print(list2.get(i).getMin_price() + "\n");
			}

			System.out.printf("Successfully written text file %s.\n", file);
			return true;

		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			return false;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private static String setFileLocation() throws IOException {
		Scanner sc = new Scanner(System.in);
		String path = "/users/andrew/citi/";
		System.out.println("Enter a filename: ");
		String filename = sc.nextLine();
		return path + filename + ".txt";
	}

	// Get Data from DB
	static List<IBM> getReport1aData() throws SQLException {
		List<IBM> data = new ArrayList<IBM>();

		String getData = "select tdate, ttime, min(openpr) as openpr, highpr, max(closepr) as closepr, lowpr, volume, abs(min(openpr) - max(closepr)) as trade_range from ibm_data group by tdate order by trade_range desc limit 1;";

		Connection cn = setDBConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(getData);
			while (rs.next()) {
				data.add(new IBM(rs.getDate("tdate"), rs.getTime("ttime"), rs
						.getFloat("openpr"), rs.getFloat("highpr"), rs
						.getFloat("lowpr"), rs.getFloat("closepr"), rs
						.getInt("volume"), rs.getFloat("trade_range")));
			}
			return data;

		} catch (SQLException e) {
			throw e;
		}
	}

	static List<Report1b> getReport1bData() throws SQLException {
		List<Report1b> data = new ArrayList<Report1b>();

		String getData = "SELECT TRADE_RANGE.tdate AS tdate, max_time, max_price, min_time, min_price, abs(openpr - closepr) AS trade_range "
				+ "FROM "
				+ "(SELECT tdate, MIN(openpr) AS openpr, MAX(closepr) AS closepr "
				+ "FROM IBM_DATA "
				+ "GROUP BY tdate) AS TRADE_RANGE "
				+ "JOIN "
				+ "(SELECT tdate, ttime AS max_time, MAX(highpr) AS max_price FROM (SELECT tdate, ttime, highpr "
				+ "FROM ibm_data "
				+ "ORDER BY highpr desc) AS A "
				+ "GROUP BY A.tdate) AS MAXIMUMS "
				+ "ON MAXIMUMS.tdate = TRADE_RANGE.tdate "
				+ "JOIN "
				+ "(SELECT tdate, ttime AS min_time, MIN(lowpr) AS min_price FROM (SELECT tdate, ttime, lowpr "
				+ "FROM ibm_data "
				+ "ORDER BY lowpr) AS B "
				+ "GROUP BY B.tdate) AS MINIMUMS "
				+ "WHERE MAXIMUMS.tdate = MINIMUMS.tdate "
				+ "GROUP BY TRADE_RANGE.tdate "
				+ "ORDER BY trade_range DESC;";
		Connection cn = setDBConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(getData);
			while (rs.next()) {
				data.add(new Report1b(rs.getDate("tdate"), rs
						.getTime("max_time"), rs.getTime("min_time"), rs
						.getFloat("max_price"), rs.getFloat("min_price")));
			}
			return data;

		} catch (SQLException e) {
			throw e;
		}
	}

}
