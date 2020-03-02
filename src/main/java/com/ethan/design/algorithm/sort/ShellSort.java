package com.ethan.design.algorithm.sort;

/**
 * 希尔排序
 * 先将整个待排序的记录序列分割成若干子序列分别进行直接插入排序，具体算法描述：
 * 1、选择一个增量序列t1,t2,...tk,其中ti>tj,tk=1;
 * 2、按增量序列个数k,对序列进行k趟排序
 * 3、每趟排序，根据对应的增量ti,将待排序列分隔成若干长度为m的子序列，分别对各子表
 *   进行直接插入排序，仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个
 *   序列的长度
 *   
 *   
 * 如：原始数组
 * 	[ 8 9 1 7 2 3 5 4 6 0] length=10
 * 初始增量 gap=length/2=5,整个数组被分成5组
 * 	[8 3] [9 5] [1 4] [7 6] [2 0]
 * 
 * 对这5组分别进行直接插入排序，结果如下，可以看到像3,5,6这些小元素都被调到前面了
 * 	[3 5 1 6 0 8 9 4 7 2 ] 
 * 
 * 缩小增量gap=5/2= 2，数组被分成2组
 *	 [3 1 0 9 7] [5 6 8 4 2]
 *
 * 对以上2组分别进行直接插入排序，结果如下:
 *   [0 2 1 4 3 5 7 6 9 8]
 *   
 * 继续缩小增量gap=2/2=1
 * 变为一组 [0 2 1 4 3 5 7 6 9 8] 
 * 
 * 数列已基本有序，再进行一次插入排序
 * 无需大量的移动操作即可完成整个数组的排序
 */
public class ShellSort {
	
	public static int[] shellSort(int[] arr) {
		int N = arr.length;
		if (N <= 1) {
			return arr;
		}
		
		int gap = N/2;
		int preIndex;
		
		while (gap > 0) {
			for (int i = 0; i < N - gap; i++ ) {
				preIndex = i;
				int current = arr[i+gap];
				
				while ((preIndex >= 0)&&arr[preIndex] > current) {
					arr[preIndex+gap] = arr[preIndex];
					preIndex-=gap;
				}
				arr[preIndex+gap] = current;
			}
			
			gap/=2;
		}
		
		return arr;
	}
}
