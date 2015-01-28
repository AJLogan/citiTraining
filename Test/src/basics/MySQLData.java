package basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLData extends DatabaseOperations {

	@Override
	public void listProducs(String category) throws SQLException {
		System.out.println("List Products " + category);
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/classfiles?"
							+ "user=root&password=root");
			st = cn.createStatement();
			rs = st.executeQuery("select * from product where product_category_code = '" + category + "'");
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
