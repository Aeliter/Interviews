package com.aeliter.study.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @description: 引用队列ReferenceQueue：虚引用的通知机制
 * @author: caibingqiang
 * @date: 2020-07-24 11:17
 * @version: V1.0
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("====================");

        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }

}
