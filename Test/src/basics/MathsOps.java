package basics;

public class MathsOps {
	public static double factorial(double n) {
		for (int i = 1; i <= n; i++) {
			n *= i;
			}
		return n;
		}
	}
