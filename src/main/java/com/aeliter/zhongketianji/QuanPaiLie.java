package com.aeliter.zhongketianji;

import java.util.Arrays;
import java.util.Scanner;

public class QuanPaiLie {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = { 1, 2, 3};
		int num = 0;
		do {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
			}
			System.out.println();
		} while (nextPermutation(array));
		System.out.println(num);
		sc.close();
	}

	public static boolean nextPermutation(int[] array) {
		// 沒有下一個全排列
		if (array.length <= 1) {
			return false;
		}
		// 从后往前找，找到第一个不满足降序的数（要考虑到重复的数字）
		int i = array.length - 2;
		for (; i >= 0 && array[i] > array[i + 1]; i--) {

		}
		// 没有全排列
		if (i == -1) {
			return false;
		}
		// 从i开始往后找到大于arr[i]的最小的数
		int k = i + 1;
		for (; k < array.length && array[k] > array[i]; k++) {

		}
		// 交换arr[i]和arr[k-1]
		swap(array, i, k - 1);
		// 重新对arr[i]后面的数排序，接下来继续进行全排列操作
		Arrays.sort(array, i + 1, array.length);
		return true;
	}

	public static void swap(int[] array, int i, int j) {
		int t =array[i];
		array[i] = array[j];
		array[j] =t;
	}

}
