package com.app.ms.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileHandling {

	public static void main(String[] args) {
	
//		try {
//			InputStreamReader isr = new InputStreamReader( System.in);
//			
//			System.out.println("Enter some letters :");
//			
//			int letters = isr.read();
//			
//			while(isr.ready()) {
//				System.out.println((char) letters);
//				letters=isr.read();
//			}
//			
//			isr.close();
//			System.out.println("resource closed");
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
//		try {
//			
//			String path = "D:\\ms\\src\\main\\java\\com\\app\\ms\\filehandling\\note.txt";
//			File file = new File("D:\\ms\\src\\main\\java\\com\\app\\ms\\filehandling\\note.txt");
//			
////			FileReader fr = new FileReader(file);
//			FileReader fr = new FileReader(path);
//
//			
//			int letters = fr.read();
//			
//			while(fr.ready()) {
//				System.out.println((char) letters);
//				letters=fr.read();
//			}
//			
//			fr.close();
//			System.out.println("resource closed");
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		
//		try{
//			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			 System.out.println("You typed:"+ br.readLine());
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
//		try{
//			String path = "D:\\ms\\src\\main\\java\\com\\app\\ms\\filehandling\\note.txt";
//			 BufferedReader br = new BufferedReader(new FileReader(path));
//			 
//			 while(br.ready()) {
////				 System.out.println( br.readLine()); // reads entire line and converts it in character
//				 System.out.println((char) br.read()); // reads one char at a time in int format, we have to convert it in char.
//			 }
//			
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
		
//		try { 
//			
//		
//		OutputStreamWriter osw = new OutputStreamWriter(System.out);
//		
//		osw.write("Hello World");
//		osw.write(97); //97 will be converted to the char.
//		osw.write(10);//10 will be converted to char.
//		osw.write('A');
//		osw.write('\n');
//		
//		char[] arr = "from char array".toCharArray();
//		
//		osw.write(arr);
//		
//		osw.flush();
//		
//		
//		}
//		catch( Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try { 
//			
//			
//			String path = "D:\\ms\\src\\main\\java\\com\\app\\ms\\filehandling\\note.txt";
//
//			FileWriter fw = new FileWriter(path, true);
//			
//			fw.write("Hello World");
//			fw.write("this should get appended");  // appends to the original content 
//			
//			
//			fw.flush();
//			
//			
//			}
//			catch( Exception e) {
//				System.out.println(e.getMessage());
//			}
		
		
		
//try { 
//			
//			
//			String path = "D:\\ms\\src\\main\\java\\com\\app\\ms\\filehandling\\note.txt";
//
//			BufferedWriter bw = new BufferedWriter( new FileWriter(path, true) );
//			
//			bw.write("Hare Krishna"); // appends to the original content 
////			bw.write("this should get appended");  
//			
//			
//			bw.flush();
//			
//			
//			}
//			catch( Exception e) {
//				System.out.println(e.getMessage());
//			}

//		try {
//			
//			File file = new File("new_file.txt");
//			
//			if (file.createNewFile()) {
//                System.out.println("File created: " + file.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//			
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
try {
			
			File file = new File("new_file.txt");

			file.delete();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
