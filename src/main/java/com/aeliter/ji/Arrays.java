package com.aeliter.ji;

public class Arrays {
	
	public static void main(String[] args) {
		int a[] = {5, 6, 83, 79};
		int max = a[0], min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
			if (min > a[i]) {
				min = a[i];
			}
		}
		System.out.println("max: " + max + ", min: " + min);
	}

}
