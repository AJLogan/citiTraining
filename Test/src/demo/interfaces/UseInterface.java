package demo.interfaces;

public class UseInterface {

	public static void main(String[] args) {
		MyInterface i = new DemoImplementation();
		i.demoMethod("Mr", "T");
		
		int sales[] = {1,2,3};
		
		System.out.println("Total Sales: " + i.totalSales(sales));
	}

}
