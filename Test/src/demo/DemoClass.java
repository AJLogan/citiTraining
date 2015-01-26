package demo;
import java.util.Scanner;

public class DemoClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int n = sc.nextInt();
		int res = n*n;
		System.out.println(n + " squared is " + res);
		sc.close();
		double dblRes = Math.sqrt(n);
		System.out.println(dblRes);
	}
}