package com.aeliter.dingdian;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-06-23 10:34
 * @version: V1.0
 */
public class Z extends X {

    Y y = new Y();
    public Z() {
        System.out.println("Z");
    }

    public static void main(String[] args) {
        new Z();
    }

}

class X {
    Y y = new Y();
    public X() {
        System.out.println("X");
    }
}

class Y {
    public Y() {
        System.out.println("Y");
    }
}
