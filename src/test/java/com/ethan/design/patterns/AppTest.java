package com.ethan.design.patterns;

import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;



/**
 * Unit test for simple App.
 */
public class AppTest extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	public static void main(final String[] args) throws UnsupportedEncodingException {
		testFile();
		String string = new String("af");
		string.getBytes("utf-8");
		
	}
	public static void testFile() {
		File file = new File("C:/Program Files/Java/jdk1.8.0_221");
		if (file.isDirectory()) {
			File[] list = file.listFiles(new FilenameFilter() {
				
				//名称过滤器，需要为文件，并且后缀为zip
				public boolean accept(File dir, String name) {
					return new File(dir,name).isFile() && name.endsWith(".zip");
				}
			});
			
			for(File temp : list) {//打印过滤后的文件名称
				System.out.println(temp.getName());
			}
		}
	}

}
