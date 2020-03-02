package com.ethan.design.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
	
	public static int[] mergeSort(int[] arr) {//归并排序递归头
		int N = arr.length;
		if (N < 2) {
			return arr;
		}
		int mid = N/2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);//左闭右开
	    int[]right = Arrays.copyOfRange(arr, mid, N);
	    return merge(mergeSort(left), mergeSort(right));//递归加合并
	}
	
	/*归并排序——将两段排序好的数组结合成一个排序数组*/
	public static int[] merge(int[] left, int[] right){//归并排序，递归体

		int index,i,j,N;
	    N = left.length+right.length;
	    int[] newArr = new int[N];
	    for (index = 0 ,i=0,j=0; index < N; index++) {//通过比较每次选一个小值
	    	if (i >= left.length) {
	    		newArr[index] = right[j++];
	    	} else if (j >= right.length) {
	    		newArr[index] = left[i++];
	    	} else if (left[i] > right[j]) {
		    	newArr[index] = right[j++];
		    } else {
		    	newArr[index] = left[i++];
		    }
	    }
		return newArr;
	}
}
