package com.aeliter.ji;

public class JiTuTongLong {

	public static void main(String[] args) {

		// 鸡兔一共35只,笼子里脚一共94只，求分别有多少只鸡和多少只兔子
		// 鸡的数量*2加上兔子的数量*4等于94。
		// 利用for循环列举出所有可能直到if满足条件。
		int sum = 35;
		int foot = 94;
		// 因为不会有奇数个脚，所以都用int型
		for (int chook = 1; chook <= foot / 2; chook++) {// 假设的鸡的个数

			int rabbit = sum - chook; // 假设的兔子的个数
			if (rabbit * 4 + chook * 2 == foot) {// 成立时就是正确的鸡兔个数，直接输出并结束循环

				System.out.println("鸡的个数是：" + chook);
				System.out.println("兔的个数是：" + rabbit);
				break;
			}
		}
	}

}
