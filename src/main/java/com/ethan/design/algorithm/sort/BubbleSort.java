package com.ethan.design.algorithm.sort;

import java.util.Arrays;

/**
 * 特点：效率低，实现简单
 * 思想：每一次排序，最大元素到达最后，剩下的重复以上步骤，直到排完所有元素
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		int arr[] = {1,45,3,23,14,3,6,2,13,3};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void sort(int[] arr) {
		int N = arr.length;
		if (N == 0) {
			return;
		}
		
		for (int i = 1; i < N; i++) {
			for(int j = 0; j < N - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
