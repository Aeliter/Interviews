package com.aeliter.rengu;

/**
 * Input：
 * 1
 * a
 * 2
 * b
 * 2
 * b
 */
public class Hello {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		A ab = new B();
		ab = new B();
	}
	
}
class A {
	
	static {
		System.out.println("1");
	}
	
	public A() {
		System.out.println("2");
	}

}

class B extends A {
	static {
		System.out.println("a");
	}
	
	public B() {
		System.out.println("b");
	}
}
