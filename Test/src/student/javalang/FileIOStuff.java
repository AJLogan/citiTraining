package student.javalang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileIOStuff {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a file location: ");
		String location = sc.nextLine();
		readFile(location);
		printBonus(location);
		printBonusSimplified(location);

	}

	public static void readFile(String location) throws IOException {

		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			f = new File(location);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null){
				br.close();
			}
			if (fr != null){				
				fr.close();
			}
		}
	}

	public static void printBonus(String location) throws IOException {
		File f = new File(location);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] row = line.split(",");
			int sales = Integer.parseInt(row[1]);
			double bonus = (sales >= 30000) ? sales * 0.1 : sales * 0.05;
			System.out.println(row[0] + " Sales " + row[1] + " bonus " + bonus);
		}
		br.close();
		fr.close();
	}

	public static void printBonusSimplified(String location) throws IOException {
		File f = new File(location);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] row = line.split(",");
			int sales = Integer.parseInt(row[1]);
			double bonus;
			if (sales >= 30000)
				bonus = sales * 0.1;
			else
				bonus = sales * 0.05;
			System.out.println(row[0] + " Sales " + row[1] + " bonus " + bonus);
		}
		br.close();
		fr.close();
	}
}
