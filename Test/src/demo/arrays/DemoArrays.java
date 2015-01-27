package demo.arrays;

import java.util.Arrays;


public class DemoArrays {

	public static void main(String[] args) {
		double[] sales = { 23000.05, 235000.10, 1999.10, 19.99 };
		System.out.println("Total Sales: $" + getTotalSales(sales));
		Arrays.sort(sales);
		System.out.println(Arrays.binarySearch(sales, 23000.05));
	}

	private static double getTotalSales(double[] arr) {
		for (double n : arr) {
			System.out.print("Month $" + n + "\n");
		}
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			total = total + arr[i];
		}
		return total;
	}
}
