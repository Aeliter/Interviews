package com.aeliter.study.jvm;

import java.lang.ref.SoftReference;

/**
 * @description: 软引用
 *
 * 内存充足的时候就保留，不够用就回收！
 *
 * @author: caibingqiang
 * @date: 2020-07-24 7:49
 * @version: V1.0
 */
public class SoftReferenceDemo {

    /**
     * 内存够用的时候就保留，不够用就回收！
     */
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);     // java.lang.Object@677327b6
        System.out.println(softReference.get());    //java.lang.Object@677327b6

        o1 = null;
        System.gc();

        System.out.println(o1);     // null
        System.out.println(softReference.get());    //java.lang.Object@677327b6
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让内存不够用导致OOM，看软引用的回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);         // java.lang.Object@677327b6
        System.out.println(softReference.get());    // java.lang.Object@677327b6

        o1 = null;

        try {
            byte[] byteArray = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);     //null
            System.out.println(softReference.get());    // null
        }

    }

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }

}
