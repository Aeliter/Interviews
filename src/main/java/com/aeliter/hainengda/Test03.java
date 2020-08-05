package com.aeliter.hainengda;

public class Test03 {
	
	public static void main(String[] args) {
		int k = 0;
		
//		System.out.println("++k: " + (++k));//1
//		System.out.println("k++: " + (k++));//1
//		System.out.println("++k: " + (++k));//3
//		System.out.println("k: " + k);//3
		k = ++k + k++ + ++k + k;
		System.out.println(k);
	}
	
}
