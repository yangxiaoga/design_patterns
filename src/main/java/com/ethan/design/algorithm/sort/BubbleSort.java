package com.ethan.design.algorithm.sort;


/**
 * 特点：效率低，实现简单
 * 思想：每一次排序，最大元素到达最后，剩下的重复以上步骤，直到排完所有元素
 * 
 */
public class BubbleSort {
	
	public static int[] sort(int[] arr) {
		int N = arr.length;
		if (N == 0) {
			return arr;
		}
		
		for (int i = 0; i < N; i++) {//最后一次N-1,J=0当判断j<0时就退出了，相当于跟自己比了
			for(int j = 0; j < N - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}
