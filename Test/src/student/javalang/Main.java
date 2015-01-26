package student.javalang;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Employee emp = new Employee();
		getInfo(emp);

		Employee emp2 = new Employee();
		getInfo(emp2);
		
		System.out.println("Name: " + emp.name + " | Salary: " + emp.salary);
		System.out.println("Name: " + emp2.name + " | Salary: " + emp2.salary);
		
		System.out.println("Average Salary: " + getAverageSalary(emp, emp2));
		
		System.out.println("Max Salary: " + getMaxSalary(emp, emp2));
		
		System.out.println("Min Salary: " + getMinSalary(emp, emp2));
		
/*
 * 		String Builder Usage
 * 		Only makes one object, rather than multiple instances of strings 
 * 		floating about the place
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
		
	}

	private static void getInfo(Employee emp){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		emp.name = sc.nextLine();
		System.out.println("Enter your salary: ");
		emp.salary = sc.nextDouble();
		}

	private static double getAverageSalary(Employee emp1, Employee emp2){
		double average = ((emp1.salary + emp2.salary)/2);
		return average;
	}
	
	private static double getMaxSalary(Employee x, Employee y){
		return Math.max(x.salary, y.salary);
	}
	
	private static double getMinSalary(Employee emp1, Employee emp2) {
		return Math.min(emp1.salary, emp2.salary);
	}
	
}