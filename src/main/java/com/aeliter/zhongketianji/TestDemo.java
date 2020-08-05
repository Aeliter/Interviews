package com.aeliter.zhongketianji;

public class TestDemo {
	
	private final void add1(int a) {
		a++;
		System.out.println(a);
	}
	
	private final void add2(MyObj obj) {
		obj.b ++;
		System.out.println(obj.b);
	}
	
	public static void main(String[] args) {
		int a = 9;
		TestDemo t = new TestDemo();
		t.add1(a);
		System.out.println(a);
		MyObj obj = new MyObj();
		t.add2(obj);
		System.out.println(obj.b);
	}
	
}
