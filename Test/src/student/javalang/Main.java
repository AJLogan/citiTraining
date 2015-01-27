package student.javalang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		DateFormat joinDate = new SimpleDateFormat("dd/mm/yy");
		Employee.setMinSalary((double) 8000);
		Employee emp = new Employee();

		Employee emp2 = new Employee("Fred", 25000, joinDate);

		System.out.println("Name: " + emp.name + " | Salary: " + emp.salary);
		System.out.println("Name: " + emp2.name + " | Salary: " + emp2.salary);

		System.out.println("Average Salary: " + getAverageSalary(emp, emp2));

		System.out.println("Max Salary: " + getMaxSalary(emp, emp2));

		System.out.println("Min Salary: " + getMinSalary(emp, emp2));

		/*
		 * String Builder Usage Only makes one object, rather than multiple
		 * instances of strings floating about the place
		 */
		StringBuilder sb = new StringBuilder();
		sb.append(emp.name);
		sb.append(" : $");
		sb.append(emp.salary);
		sb.append("\n");
		sb.append(emp2.name);
		sb.append(" : $");
		sb.append(emp2.salary);
		System.out.println(sb.toString());

		Employee.setBonus(15);
		emp.calcSalaryIncBonus();
		emp2.calcSalaryIncBonus();
		System.out.println("Bonus's Calculated");
		System.out.println(emp.toString());
		System.out.println(emp2.toString());
	}

	private static double getAverageSalary(Employee emp1, Employee emp2) {
		double average = ((emp1.salary + emp2.salary) / 2);
		return average;
	}

	private static double getMaxSalary(Employee x, Employee y) {
		return Math.max(x.salary, y.salary);
	}

	private static double getMinSalary(Employee emp1, Employee emp2) {
		return Math.min(emp1.salary, emp2.salary);
	}

}