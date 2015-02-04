package demo.layered;

import java.sql.SQLException;
import java.util.List;

public class CountryBL {
	// Business Logic Layer
	public List<Country> getCountries() throws SQLException {
		return CountryDAL.allCountries();
	}

	public Country getCountryByID(int id) throws SQLException {
		return CountryDAL.getCountryByID(id);
	}

	public Country getCountryByName(String name) throws SQLException {
		return CountryDAL.getCountryByName(name);
	}

	public int addCountry(Country c) throws SQLException {
		return CountryDAL.addCountry(c);
	}

	public boolean editName(Country c) throws SQLException {
		return CountryDAL.editName(c);
	}

	public boolean editCapital(Country c) throws SQLException {
		return CountryDAL.editCapital(c);
	}

	public boolean editPopulation(Country c) throws SQLException {
		return CountryDAL.editPopulation(c);
	}

	public boolean deleteCountry(Country c) throws SQLException {
//		This will not work if there are contacts associated with a country
		return CountryDAL.deleteCountry(c);
	}
}