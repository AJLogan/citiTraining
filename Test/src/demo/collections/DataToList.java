package demo.collections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.BankAccount;

public class DataToList {

	public static void main(String[] args) throws SQLException {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		getAccountsFromDB(accounts, "s");
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i));
		}
	}

	public static void getAccountsFromDB(List<BankAccount> accounts, String pay_type_code) throws SQLException {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/classfiles?"
							+ "user=root&password=root");
			st = cn.createStatement();
			rs = st.executeQuery("select concat(firstname, ' ', lastname) ac, pay_amount as balance "
					+ "FROM person p join employee e "
					+ "ON p.id = e.id where pay_type_code = '"
					+ pay_type_code
					+ "'");
			while (rs.next()) {
				accounts.add(new BankAccount(rs.getString("ac"), rs.getDouble("balance")));
//				System.out.println(rs.getString("ac") + " "
//						+ rs.getDouble("balance"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (cn != null)
				cn.close();
		}

	}

}
