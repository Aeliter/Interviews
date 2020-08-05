package com.aeliter.ShiDongShiJi;

public class Main02 {
	
	public static void main(String[] args) {
		
		//创建并启动线程
		MyThread02 myThread02 = new MyThread02();
		Thread thread = new Thread(myThread02);
		
		thread.start();
		
		// new Thread(new MyThread02()).start();
		
	}

}
