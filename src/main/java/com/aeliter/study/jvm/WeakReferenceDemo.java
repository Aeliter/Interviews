package com.aeliter.study.jvm;

import java.lang.ref.WeakReference;

/**
 * @description: 弱引用
 * @author: caibingqiang
 * @date: 2020-07-24 8:20
 * @version: V1.0
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();

        System.out.println("====================");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }

}
