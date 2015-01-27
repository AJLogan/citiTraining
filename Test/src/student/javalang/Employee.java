package student.javalang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Employee {
	String name;
	Double salary;
	DateFormat joinDate = new SimpleDateFormat("dd/mm/yy");
	static Double bonus;
	static Double minSalary = (double) 7000;

	public Employee(String name, double salary, DateFormat joinDate) {
		this.name = name;
		this.salary = salary;
		this.joinDate = joinDate;
	}

	public Employee() {
		this.name = "Andrew";
		this.salary = this.getMinSalary();
		this.joinDate = DateFormat.getDateTimeInstance();
	}

	public static void setBonus(double bonus) {
		// Set interest rate globally
		Employee.bonus = bonus;
	}

	public static void setMinSalary(Double minSalary) {
		// Set Minimum Salary
		Employee.minSalary = minSalary;
	}

	public double getMinSalary() {
		return Employee.minSalary;
	}

	public void calcSalaryIncBonus() {
		salary = salary * (1 + bonus);
	}

	@Override
	public String toString() {
		String str = String.format("Name: %s | Salary: $%.2f | Start Date: ",
				name, salary, joinDate);
		return str;
	}
}
