package demo.arrays;

public class NDimensionalArrays {

	public static void main(String[] args) {
		demo2DArray();
	}

	private static void demo2DArray() {
		int[][] tables = { 	{ 1, 2, 3, 4, 5, 6 },
							{ 2, 4, 6, 8, 10, 12, 14, 16, 18 }, 
							{ 3, 6, 9, 12, 15, 18 } 
							};
		// Using a double for loop, output the array
		for (int i = 0; i < tables.length; i++) {
			for (int j = 0; j < tables[i].length; j++) {
				System.out.print(tables[i][j] + "\t");
			}
			System.out.println();
		}
	}
}