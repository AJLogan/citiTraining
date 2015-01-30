package contacts.databaseinteration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ContactManager {

	public static void main(String[] args) throws SQLException {
		// createContact();
		// searchForContact("Andrew");
		// System.out.println(lookupCountry("wales"));
		// createContact();
		// updateContact();

		// getContactsInCountry();
		deleteContact();
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

	private static void updateContact() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Who do you want to update?: ");
		String who = sc.next();

		System.out.println("Enter the new information for " + who);
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

		String updateContactQuery = "UPDATE contact " + "set first_name = ?, "
				+ "last_name = ?, " + "email = ?, " + "phone = ?, "
				+ "country_id = ?" + "WHERE first_name like '" + who + "';";

		String cid = Integer.toString(lookupCountry(country));
		String[] accounts = { firstname, lastname, phoneno, emailadd, cid };

		DatabaseUtils.executePreparedStatement(DatabaseUtils.setupDB(),
				updateContactQuery, accounts);
		System.out.println("Success!... You have updated the information for: "
				+ who);
	}

	private static void getContactsInCountry() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter country: ");
		String param = sc.nextLine();
		String query = "{ call contactsInCountry(?) }";

		ResultSet rs = null;
		try {
			rs = DatabaseUtils.executeStoredProc(DatabaseUtils.setupDB(),
					query, param);
			while (rs.next() != false) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String country = rs.getString("country");
				System.out.println(first_name + " | " + last_name + " | "
						+ phone + " | " + email + " | " + country);
			}
		} catch (SQLException e) {
			System.out.println("Error executing SELECT statement: " + e);
		}
	}

	private static int getContactID(String who) {
		String lookupContact = "select contact_id from contact where first_name like '"
				+ who + "';";

		ResultSet rs = null;
		int id = 0;
		try {
			rs = DatabaseUtils.executeQuery(DatabaseUtils.setupDB(),
					lookupContact);
			while (rs.next() != false) {
				id = rs.getInt("contact_id");
			}
		} catch (SQLException e) {
			System.out.println("Error executing SELECT statement: " + e);
		}
		return id;

	}

	private static void deleteContact() throws SQLException {
		System.out.println("Which contact would you like to delete?: ");
		Scanner sc = new Scanner(System.in);
		String victim = sc.nextLine();

		if (getContactID(victim) > 0) {
			System.out.println("Are you sure you would like to delete "
					+ victim);
			System.out.println("Enter Y or N");
			String response = sc.nextLine();

			if (response.equals("Y") | response.equals("y")) {
				String deleteContactQuery = "DELETE from contact where contact_id = "
						+ getContactID(victim) + ";";
				DatabaseUtils.executeUpdate(DatabaseUtils.setupDB(),
						deleteContactQuery);
				System.out.println("Contact: " + victim + " has been deleted.");
			}
			if (response.equals("N") | response.equals("n")) {
				System.out.println("Contact: " + victim
						+ " has not been deleted.");
			} 
			else {
				System.out.println("Invalid Entry on Keyboard");
			}

		}

	}

}
