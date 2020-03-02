package com.ethan.design.algorithm.sort;

/**
 * 选择排序
 * 每次找一个最小值，直到N-1次
 *
 */
public class SelectSort {
	public int[] selectSort(int[] arr) {
		int N = arr.length;
		if(N == 0) {
			return  arr;
		}
		
		for (int i=0; i < N; i++) {
			int min = i;
			for (int j = i; j < N; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr; 
	}
}
