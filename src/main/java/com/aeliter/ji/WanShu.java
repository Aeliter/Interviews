package com.aeliter.ji;

/**
 * 完全数：（Perfect Number）又称完美数或完备数，是一些特殊的自然数。它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 如果一个数恰好等于它的因子之和，则称该数为“完全数”。
 * 需求：判断并输出1000以内的所有完全数。
 * 
 * 题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程 找出1000以内的所有完数。
 *
 */
public class WanShu {

	/*public static void main(String[] args) {
		int s;
		for (int i = 1; i <= 1000; i++) {
			s = 0;
			for (int j = 1; j < i; j++)
				if (i % j == 0)
					s = s + j;
			if (s == i)
				System.out.print(i + " ");
		}
		System.out.println();
	}*/
	
	public static void main(String[] args) {
		System.out.println("1000以内的所有完数有：");
		for (int i = 2; i < 1000; i++) {// 遍历1000以内的所有整数
			int sum = 0;// 定义和变量
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {// 满足是i的因子,就累加
					sum += j;
				}
			}
			if (sum == i) {// 满足因子之和等于i就打印该完数
				System.out.print(i + " ");
			}
		}
	}

}
