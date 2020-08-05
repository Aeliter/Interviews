package com.aeliter.danli;

// 恶汉单例模式
// 1. 不能让外界去new
// 2. 给外界提供一个方法，能得到唯一一个实例
public class Singleton2 {
	
	private static final Singleton2 singleton2 = new Singleton2();
	private Singleton2() {} // 实例化，保证外界new不了
	public static Singleton2 getInstance() {
		return singleton2;
	}
	
}
