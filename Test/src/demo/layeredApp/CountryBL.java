package demo.layeredApp;

import java.sql.SQLException;
import java.util.List;

public class CountryBL {
	// Business Logic Layer

	public List<Country> getCountries() throws SQLException {
		return CountryDAL.allCountries();
	}

	public int addCountry(Country c) throws SQLException {
		return CountryDAL.addCountry(c);
	}

	public boolean editPopulation(Country c) throws SQLException {
		return CountryDAL.editPopulation(c);
	}
}