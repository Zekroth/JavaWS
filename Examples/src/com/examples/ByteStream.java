package com.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream extends Thread{
	
	public static void main(String[] args) {
		String path = "C:\\Users\\edbarchies\\git\\JavaWS\\Examples\\settings.xml";
		System.out.println(readFile(path));
		
	}
	public static synchronized String legacyReadFile() {
		String output = "";
		FileInputStream in = null;
		try {
			
			in = new FileInputStream("C:\\Users\\edbarchies\\git\\JavaWS\\Examples\\settings.xml");
			int i = 0;
			while((i = in.read()) != -1)
				output += (char) i;
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				in.close();
			}catch ( IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return output;
	}
	public static synchronized String readFile(String path) {
		String output = "";
		try (FileInputStream in = new FileInputStream(path)){
			int i = 0;
			while((i = in.read()) != -1) {
				output += (char)i;
			}
		}catch(IOException e) {
			System.out.println("There was an error: "+ e.getMessage());
		}
		return output;
	}
	public static synchronized void writeFile(String text, String path) {
		do {
			try(FileOutputStream fos = new FileOutputStream(path)){
				for(char c : text.toCharArray()) {
					fos.write(c);
				}
				break;
			}catch(FileNotFoundException e) {
				System.out.println("File not found, creating the file");
				File f = new File(path);
				try {
					f.createNewFile();
					continue;
				} catch (IOException e1) {
					System.out.println("There was a problem with the file creation");
					break;
				}
			} catch (IOException e) {
				System.out.println("There was a problem with the file writing");
				break;
			}
		}while(true);
		
		ByteStream.class.notify();
	}
	

}
