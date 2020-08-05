package com.aeliter.dongruan;

public class A extends Thread {
	
	A() {
		setDaemon(true);
	}
	
	public void run() {
		(new B()).start();
		try {
			Thread.sleep(60000);
		} catch (InterruptedException x) {
			System.out.println("A done");
		}
		
		
	}
	class B extends Thread {
		public void run() {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException x) {
				System.out.println("B done");
			}
		}
	}
	
	public static void main(String[] args) {
		(new A()).start();
	}

}
