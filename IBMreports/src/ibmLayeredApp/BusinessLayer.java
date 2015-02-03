package ibmLayeredApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BusinessLayer {
	List<IBM> getReport1aData() throws SQLException {
		return DataAccess.getReport1aData();
	}

	List<Report1b> getReport2Data() throws SQLException {
		return DataAccess.getReport1bData();
	}

	boolean writeReportToFile(List<IBM> list, List<Report1b> list2)
			throws IOException {
		return DataAccess.writeReportToFile(list, list2);
	}
}
