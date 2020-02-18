package com.ethan.design.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作相关
 */
public class FileOperation {
	
	public static void main(String[] args) {
/*		File origin = new File("C:/Users/Administrator/Desktop/java.txt");
		File destination = new File("C:/Users/Administrator/Desktop/temp.txt");
		fileCopy(origin, destination);*/
		
		File origin = new File("C:/Users/Administrator/Desktop/1");
		File destination = new File("C:/Users/Administrator/Desktop/m");
		
		folderCopy(origin, destination);
	}
	
	/**
	 * 文件夹的拷贝 
	 */
	
	public static void folderCopy(File origin, File destination) {
		if (origin == null || destination == null){ return; }
		if (origin.isDirectory()) {//源头为目录
			destination.mkdirs();//确保目标路径存在
			
			for (File son : origin.listFiles()) {
			    folderCopy(son, new File(destination, son.getName()));
			}

		} else {//源头是文件，直接拷贝
			
			if (destination.isDirectory()) {//目标是目录
				destination = new File(destination, origin.getName());
			}
			fileCopy(origin, destination);
		}
		
	}
	
	/**
	 * 文件的拷贝 
	 */
    public static void fileCopy(File origin, File destination) {
    	InputStream iStream = null;
    	OutputStream oStream = null;
    	byte[] buffer = new byte[10];
    	try {
    		              //处理流                                            //节点流
    		iStream = new BufferedInputStream(new FileInputStream(origin));
    		oStream = new BufferedOutputStream(new FileOutputStream(destination, false));
    		
			int length;
			while ((length = iStream.read(buffer)) != -1) {
    			oStream.write(buffer, 0, length);
    		}
    		oStream.flush();
    		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{//关闭流
				if (oStream != null) {
					oStream.close();
				}
				if (iStream !=null) {
					iStream.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
    	
    }
}
