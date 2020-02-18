package com.ethan.design.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterReader {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Administrator/Desktop/java.txt");
		File file1 = new File("C:/Users/Administrator/Desktop/tt.txt");
		read(file, file1);
	}
	
	/**
	 * 文件纯文本的读取
	 * @throws IOException 
	 */
	public static void read(File orin, File dest) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(orin)) ;
		BufferedWriter writer = new BufferedWriter(new FileWriter(dest)) ;
		
		/*char[] cBuffer = new char[1024];
		int length; 
		while((length = reader.read(cBuffer)) != -1) {
			writer.write(cBuffer, 0, length);
		}*/
		String s = null;
		while((s = reader.readLine()) != null) {
			writer.write(s);
			writer.newLine();
		}
		writer.flush();
		try{
			if (writer != null) {
				writer.close();
			}
			if (reader != null) {
				reader.close();
			}
			
		}catch(IOException e) {
			
		}
	}
}
