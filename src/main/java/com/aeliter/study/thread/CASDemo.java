package com.aeliter.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1、CAS是什么？ --> CompareAndSet
 *  比较并替换
 */
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        // main do things...
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());

        atomicInteger.getAndIncrement();
    }

}
