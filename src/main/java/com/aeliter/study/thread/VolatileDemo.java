package com.aeliter.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {

    /** volatile保证可见性 */
    volatile int number = 0;
    public void addTo60() {
        this.number = 60;
    }

    /** 此时number前面是加了volatile关键字修饰的，不保证原子性 */
    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }

}

/**
 * 1、验证volatile的可见性
 *  1.1 假如 int number = 0; number变量之前根本没有添加volatile关键字修饰，没有可见性
 *  1.2 添加了volatile，可以解决可见性问题
 *
 * 2、验证volatile不保证原子性
 *  2.1 原子性指的是什么意思？
 *      不可分割，完整性，即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要整体完整，要么同时成功，要么同时失败
 *  2.2 volatile不保证原子性的案例演示
 *  2.3 为什么不保证原子性
 *  2.4 如何解决原子性？
 *      * 加Synchronized
 *      * 直接使用JUC下的AtomicInteger
 */
public class VolatileDemo {

    public static void main(String[] args) {
//        seeOkByVolatile();
        MyData myData = new MyData();

        for (int i = 1; i < 20; i++) {
            new Thread(() -> {
                for (int j = 1; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程计算完成后，再用main取值
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger finally number value:" + myData.atomicInteger);
    }

    /**
     * volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
     */
    public static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 暂停一会儿线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value" + myData.number);
        }, "AAA").start();

        // 2、第二个线程就是main线程
        while (myData.number == 0) {
            // main线程一直等待循环，直到number不等于0

        }
        System.out.println(Thread.currentThread().getName() +
                "\t mission is over,main get number value:" + myData.number);
    }

}
