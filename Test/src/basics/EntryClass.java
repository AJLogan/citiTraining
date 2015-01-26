package basics;
import java.util.Scanner;

public class EntryClass {
	public static void main(String[] args) {
		System.out.println("Enter A Number: ");
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		double res = MathsOps.factorial(n);
		System.out.println("The factorial of " + n + " is " + res);
		sc.close();
	}
}