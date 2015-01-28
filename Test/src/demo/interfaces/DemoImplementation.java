package demo.interfaces;

public class DemoImplementation implements MyInterface {

	@Override
	public void demoMethod(String first, String last) {
		System.out.println(first + " " + last);
	}

	@Override
	public int totalSales(int[] sales) {
		int total = 0;
		for (int i = 0; i < sales.length; i++){
			total = total + sales[i];
		}
		return total;
	}

}
