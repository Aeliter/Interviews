package com.aeliter.danli;

// 饱汉单例模式
// 和恶汉的区别：
// 1. 饱汉是在调用方法的时候才去new，而恶汉是在类加载的时候直接new
// 2. 饱汉是线程同步的，恶汉是线程异步的
public class Singleton1 {
	
	private static Singleton1 singleton = null;
	private Singleton1() {}
	public static synchronized Singleton1 getInstance() {
		
		// 双重保护
		if(singleton == null) {
			singleton = new Singleton1();
		}
		
		return singleton;
	}

}
