package basics;

import java.sql.SQLException;

public abstract class DatabaseOperations {

	public abstract void listProducs(String category) throws SQLException;
	
	public void demoMethod(){
		System.out.println("Demo Implemented methos in abstract class");
	}

}
