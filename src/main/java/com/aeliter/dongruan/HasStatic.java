package com.aeliter.dongruan;

public class HasStatic {
	
	private static int x = 100;
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		HasStatic hs1 = new HasStatic();
		hs1.x++;
		
		HasStatic hs2 = new HasStatic();
		hs2.x++;
		
		hs1 = new HasStatic();
		hs1.x++;
		
		HasStatic.x--;
		System.out.println("x = " + x);
		
	}

}
