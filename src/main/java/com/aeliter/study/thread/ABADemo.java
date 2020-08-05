package com.aeliter.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description: ABA问题的解决
 * @author: caibingqiang
 * @date: 2020-07-16 17:34
 * @version: V1.0
 */
public class ABADemo {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {

        System.out.println("===以下是ABA问题的产生===");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            // 先暂停1秒钟 t2 线程，保证上面的 t1 线程完成一次ABA操作
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(atomicReference.compareAndSet(100, 2020) + "\t" + atomicReference.get());
        }, "t2").start();
        // 保证以上的ABA问题彻底执行完毕
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("===以下是ABA问题的解决===");

        new Thread(() -> {
            // 初始版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号：" + stamp);
            // 暂停1秒钟 t3 线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

            atomicStampedReference.compareAndSet(100, 101,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第2次版本号：" +
                    atomicStampedReference.getStamp() + "\t值是" + atomicStampedReference.getReference());

            atomicStampedReference.compareAndSet(101, 100,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第3次版本号：" +
                    atomicStampedReference.getStamp() + "\t值是" + atomicStampedReference.getReference());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号：" + stamp);
            // 暂停3秒钟 t4 线程，保证线程 t3 也完成1次ABA操作
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

            boolean result = atomicStampedReference.compareAndSet(100, 2020,
                    stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t 修改成功否：" + result +
                    "\t当前最新实际版本号：" + atomicStampedReference.getStamp());
            System.out.println("当前实际最新的值：\t" + atomicStampedReference.getReference());
        }, "t4").start();
    }

}
