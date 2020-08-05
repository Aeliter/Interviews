package com.aeliter.study.jvm;

/**
 * @description: 强引用
 * @author: caibingqiang
 * @date: 2020-07-23 23:47
 * @version: V1.0
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object(); // 这样定义的默认就是强引用
        Object obj2 = obj1; // obj2引用赋值
        obj1 = null;    // 置空
        System.gc();
        System.out.println(obj2);
    }

}
