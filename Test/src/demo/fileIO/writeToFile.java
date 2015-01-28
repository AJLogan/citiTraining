package demo.fileIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class writeToFile {

	public static void main(String[] args) throws IOException {
		
//		createFile();
		deleteFile();

	}
	
	public static void createFile() throws IOException{
		Scanner sc = new Scanner(System.in);
		String path = "/users/andrew/citi/";
		System.out.println("Enter a filename: ");
		String filename = sc.nextLine();
		File userFile = new File(path + filename);
		
		if (userFile.exists()){
			System.out.println("File Exists");
		}
		else {
			userFile.createNewFile();
			System.out.print("Created new file: " + userFile.toString());
		}
	}
	
	public static void deleteFile() throws IOException{
		Scanner sc = new Scanner(System.in);
		String path = "/users/andrew/citi/";
		System.out.println("Enter a filename: ");
		String filename = sc.nextLine();
		File userFile = new File(path + filename);
		
		if (userFile.exists()){
			userFile.delete();
			System.out.println("File Deleted: " + userFile);
		}
		else {
			System.out.print("File does not exist: " + userFile.toString());
		}
	}

}
