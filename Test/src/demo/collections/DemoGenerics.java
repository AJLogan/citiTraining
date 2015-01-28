package demo.collections;

import java.util.ArrayList;

public class DemoGenerics {

	public static void main(String[] args) {
		ArrayList rl = new ArrayList();
		rl.add("Demo");
		String first = (String) rl.get(0);
		System.out.println(first);
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("Demo Generic");
		first = words.get(0);
		System.out.println(first);
	}

}
