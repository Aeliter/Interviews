package com.aeliter.vmware;

public class Base1 {
	public static void test() {
		System.out.println("a");
	}
	public static void main(String[] args) {
		Base1 base = new Base1();
		Base1 dToB = new Derived();
		Derived dervived = new Derived();
		base.test();
		dToB.test();
		dervived.test();
	}

}
