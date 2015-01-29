package contacts.databaseinteration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ContactManager {

	public static void main(String[] args) throws SQLException {
		// createContact();

		searchForContact("Andrew");
		System.out.println(lookupCountry("wales"));
		createContact();
	}

	public static void createContact() throws SQLException {
		// Get info via prompt
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First name: ");
		String firstname = sc.next();
		System.out.println("Enter Last name: ");
		String lastname = sc.next();
		System.out.println("Enter Phone number: ");
		String phoneno = sc.next();
		System.out.println("Enter email: ");
		String emailadd = sc.next();
		System.out.println("Enter Country: ");
		String country = sc.next();

		String addContactQuery = " INSERT into contact (first_name, last_name, phone, email, country_id)"
				+ " VALUES ('"
				+ firstname
				+ "', '"
				+ lastname
				+ "', '"
				+ phoneno
				+ "', '"
				+ emailadd
				+ "', '"
				+ lookupCountry(country)
				+ "');";

		DatabaseUtils.executeUpdate(DatabaseUtils.setupDB(), addContactQuery);
		System.out.println("Success!... You have added: ");
		searchForContact(firstname);
	}

	private static int lookupCountry(String country) throws SQLException {

		String findCountryQuery = "SELECT country.country_id  from country where country.name like '"
				+ country + "'";

		ResultSet rs = null;
		int countryID = 0;
		try {
			rs = DatabaseUtils.executeQuery(DatabaseUtils.setupDB(),
					findCountryQuery);
			while (rs.next() != false) {
				countryID = rs.getInt("country_id");
			}
		} catch (SQLException e) {
			System.out.println("Error executing SELECT statement: " + e);
		}
		return countryID;
	}

	public static void searchForContact(String who) throws SQLException {
		String lookupContact = "select * from contact where first_name like '"
				+ who + "';";

		ResultSet rs = null;
		try {
			rs = DatabaseUtils.executeQuery(DatabaseUtils.setupDB(),
					lookupContact);
			while (rs.next() != false) {
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String email = rs.getString("email");
				System.out.println(firstname + " " + lastname + "\n  " + email);
			}
		} catch (SQLException e) {
			System.out.println("Error executing SELECT statement: " + e);
		}

	}

	public static void updateContact() {

	}

	public static void removeContact() {

	}

}
