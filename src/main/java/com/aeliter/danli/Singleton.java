package com.aeliter.danli;

/**
 * 单例模式
 * @author 10473
 *
 * 双重校验锁实现对象单例（线程安全）
 * volatile可以禁止JVM指令重排，保证在多线程环境下也能正常运行
 */
public class Singleton {
	
	private static volatile Singleton uniqueInstance;
	private Singleton() {
	}
	public static Singleton getUniqueInstance() {
		// 先判断对象是否已经实例过，没有实例化才进入加锁代码
		if(uniqueInstance == null) {
			//类对象加锁，有时存在几个线程同时运行到这里，为了安全所以需要上锁，阻塞某些线程
			synchronized(Singleton.class) {
				//如果至少2个线程先后获得同步锁，这个判空条件将保证只new一次实例
				if(uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
	
}
