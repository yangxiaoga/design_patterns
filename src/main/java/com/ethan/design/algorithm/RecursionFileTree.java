package com.ethan.design.algorithm;
import java.io.File;

public class RecursionFileTree {
	
	public static void main(String[] args) {
		File file = new File("E:/Linux");
		printFileTre(file, 0);
	}
	/**
	 * 递归打印文件目录树
	 * @param file 需要打印的目录或文件
	 * 如：文件路径为 E:/Linux
	 * Linux
	 * -disk
	 * --CentOS 64 位.nvram
	 * --CentOS 64 位.vmdk
	 */
	public static void printFileTre(File file, int level) {
		int temp = level;
		for (int i=0; i < temp; i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for(int j =0; j<files.length; j++){
				printFileTre(files[j], temp+1);
			}
		}
	}
}
