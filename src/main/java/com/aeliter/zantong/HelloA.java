package com.aeliter.zantong;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-27 10:30
 * @version: V1.0
 */
public class HelloA {

    public HelloA() { System.out.println("HelloA"); }

    { System.out.println("I'm A class"); }

    static { System.out.println("static A"); }

}

class HelloB extends HelloA {

    public HelloB() { System.out.println("HelloB"); }

    { System.out.println("I'm B class"); }

    static { System.out.println("static B"); }

    public static void main(String[] args) {
        new HelloB();
    }

}
