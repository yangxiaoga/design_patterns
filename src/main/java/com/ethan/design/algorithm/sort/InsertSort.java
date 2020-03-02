package com.ethan.design.algorithm.sort;

/**
 * 插入排序
 */
public class InsertSort {
	public static int[] sort(int[] arr) {
		
		for (int i = 0; i < arr.length-1; i++) {
			 
			 
			 /*    
			 *                       i+1
			 *                       currentIndex
			 *                        |
			 *  [ ]          [ ]     [ ]  [ ] [ ] [ ] [ ] [ ] [ ] 
			 *   |            |
			 * preIndex--     preIndex   
			 *  while跳出位置         |
			 *                 i
			 */
			
			int preIndex = i;
			int current = arr[i+1];
			while(preIndex >= 0 && current < arr[preIndex]) {
				arr[preIndex + 1] = arr[preIndex]; //需要安排位置的元素比当前的小，当前元素就往后移动
				preIndex--;
			}
			/**当移动之后，发现指针已经<0|需要安排位置的元素比指针指向的元素小*/
			arr[preIndex+1] = current; //设置该元素
		}
		
		return arr;
	}
}
