package basics;

import java.sql.SQLException;

public class TestAbstractAncConcrete {

	public static void main(String[] args) throws SQLException {
		DatabaseOperations dop = new MySQLData();
		dop.listProducs("Hardware");
		
		dop.demoMethod();
	}
}
