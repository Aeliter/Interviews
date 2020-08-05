package com.aeliter.dongruan;

public class Test07 {
	
	private static int j = 0;
	private static boolean methodB(int k) {
		j += k;
		return true;
	}
	
	@SuppressWarnings("unused")
	public static void methodA(int i) {
		boolean b;
		b = i < 10 | methodB(4);
		b = i < 10 || methodB(8);
	}
	public static void main(String[] args) {
		methodA(0);
		System.out.println(j);
	}

}
