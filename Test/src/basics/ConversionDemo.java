package basics;

import java.util.Scanner;

public class ConversionDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.MAX_VALUE;
		long l = n;
		System.out.println(" l = " + l);
		System.out.println("Enter a number: ");
		l = sc.nextLong();
		n = (int) l;
		System.out.println(" n = " + n);
		System.out.println(" l = " + l);
		}
	}
