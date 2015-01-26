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
	
	private static double getMaxSalary(Employee emp1, Employee emp2){
		return Math.max(emp1.salary, emp2.salary);
	}
	
	private static double getMinSalary(Employee emp1, Employee emp2) {
		return Math.min(emp1.salary, emp2.salary);
	}
	
}