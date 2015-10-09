package mainclasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessExample1 {

	public static void main(String[] args) throws IOException{
		Scanner keyboard = new Scanner(System.in);
		FileWriter fw = new FileWriter("test.dat",false);
		System.out.println("enter a message to print to file");
		//original message
		RandomAccessFile file = new RandomAccessFile("test.dat", "rw");
		String userIn = keyboard.nextLine();
		file.writeChars(userIn);
		System.out.println("Printing message to file: "+userIn);
		file.close();
		//new file write
		RandomAccessFile file2 = new RandomAccessFile("test.dat", "rw");
		System.out.println("Where to begin insert?(expects an integer for which character to start at)");
		int userInt = keyboard.nextInt();
		userInt *=2;
		file2.seek(userInt);
		StringBuilder sb = new StringBuilder();
		//checks for end of file
		while(!(file2.getFilePointer()>=file2.length())){
		sb.append(file2.readChar());
		}
		
		//inserts the message at specified point
		String concat = sb.toString();
		file2.seek(userInt);
		//cleans newline
		keyboard.nextLine();
		//grabs user insert input
		System.out.println("What would you like to insert?: ");
		String userInput2 = keyboard.nextLine();
		file2.writeChars(userInput2);
		file2.writeChars(concat);
		file2.seek(0);
		
		//prints file contents in a readable console output
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0 ; i < file2.length(); i++){
			char characterB = (char)file2.read();
			if(Character.valueOf(characterB)==0){
				sb2.append("");
			}else if(characterB == ''){
				sb2.append(" ");
			}else{
				sb2.append(characterB);
			}
		}
		System.out.println(sb2);
		file2.close();
	}

}
