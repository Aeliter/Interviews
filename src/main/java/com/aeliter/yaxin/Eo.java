package com.aeliter.yaxin;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-04-04 11:58
 * @version: V1.0
 */
public interface Eo {

    double PI = 3.1415926;

}

abstract class A {

    void shoo() {
        System.out.println("我是抽象类...");
    }

    abstract void duandian();

}

abstract class C extends A {

    @Override
    void shoo() {
        System.out.println("你好啊...");
    }

}

class D extends C implements Eo {

    @Override
    void duandian() {
        System.out.println("我是子类c..." + PI);
    }

}

class B {

    public static void main(String[] args) {
        D t = new D();
        t.duandian();
    }

}
