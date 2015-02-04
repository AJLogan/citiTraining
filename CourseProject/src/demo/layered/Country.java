package demo.layered;

public class Country {
	// Business Object
	private int id;
	private String name;
	private String capital;
	private long population;

	// Constructor
	public Country(int id, String name, String capital, long population) {
		this.id = id;
		this.name = name;
		this.capital = capital;
		this.population = population;
	}

	// Getters / Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	// Overridden toString Method
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capital=" + capital
				+ ", population=" + population + "]";
	}
}
