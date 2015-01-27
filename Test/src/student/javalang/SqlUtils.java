package student.javalang;

import java.sql.*;

public class SqlUtils {

	public static void main(String[] args) throws SQLException {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/classfiles?"
							+ "user=root&password=root");
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM product WHERE price > 140");
			while (rs.next()) {
				System.out.println(rs.getString("description") + " "
						+ rs.getDouble("price"));
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
