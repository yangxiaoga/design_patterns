package com.ethan.design.algorithm.sort;

import java.util.Arrays;

/**
 * @author Administrator
 *
 */
public class SortTest {
	public static void main(String[] args) {
		int arr[] = {1,45,3,23,14,3,6,2,13,3,1};
		//SortTest.bubbletTest(arr);
		//SortTest.insertTest(arr);
		//SortTest.shellTest(arr);
		SortTest.mergeTest(arr);
	}
	static void bubbletTest(int[] arr) {
		int[] m = BubbleSort.sort(arr);
		System.out.println(Arrays.toString(m));
	}
	static void insertTest(int[] arr) {
		int[] m = InsertSort.sort(arr);
		System.out.println(Arrays.toString(m));
	}
	
	static void shellTest(int[] arr) {
		int[] m =ShellSort.shellSort(arr);
		System.out.println(Arrays.toString(m));
	}
	static void mergeTest(int[] arr) {
		int[] m =MergeSort.mergeSort(arr);
		System.out.println(Arrays.toString(m));
	}
}
