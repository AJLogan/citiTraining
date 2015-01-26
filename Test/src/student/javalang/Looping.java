package student.javalang;

import java.util.Scanner;

public class Looping {

	public static void main(String[] args) {
		getSomeNames(2);
		downTen();
	}

	// While Loop
	private static void getSomeNames(int n) {
		Scanner sc = new Scanner(System.in);
		String[] thenames = new String[n];
		/*
		 * thenames.length is the number of elements in the array all arrays are
		 * indexed from 0 add a while loop to prompt for the names and output
		 * them after
		 */
		int x = 0;
		while (x < thenames.length) {
			System.out.println("(" + x + "Enter a name: ");
			thenames[x] = sc.nextLine();
			x++;
		}
		// While loop
		System.out.println("While Loop Example");
		int i = 0;
		while (i < thenames.length) {
			System.out.print(thenames[i] + "\n");
			i++;
		}
		// For Loop
		System.out.println("For Loop Example");
		for (int j = 0; j < thenames.length; j++) {
			System.out.println(thenames[j]);
		}
	}

	/*
	 * Display 100 - 50 in downward steps of 10
	 */
	private static void downTen() {
		for (int down = 100; down > 50; down -= 10)
			System.out.println(down);
	}

}
