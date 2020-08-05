package com.aeliter.zhongkeruan;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-28 9:18
 * @version: V1.0
 */
public class Test1 {

    public static void main(String[] args) {
        String a = new String("foo");
        String b = new String("foo");

        System.out.println(a == b);         // false
        System.out.println(a.equals(b));    // true

    }

}
