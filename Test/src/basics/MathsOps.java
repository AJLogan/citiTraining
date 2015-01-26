package basics;

public class MathsOps {
	public static double factorial(double n) {
		if (n == 1 || n == 0) {
			return 1;
			} else {
				return n * factorial(n - 1);
				}
		}
	}
