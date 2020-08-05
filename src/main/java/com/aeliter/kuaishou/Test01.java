package com.aeliter.kuaishou;

public class Test01 {
	public static void main(String[] args) {
		int i = 0;
		try {
			i++;
//			return i;
		} catch (Exception e) {
			// TODO: handle exception
			i++;
		} finally {
			i++;
		}
	}
}
