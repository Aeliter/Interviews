package com.aeliter.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * 自旋锁（spinlock）：
 * 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗CPU。
 *
 * 题目：实现一个自旋锁
 * 自旋锁的好处：循环比较获取知道成功为止，没有类似 wait 的阻塞。
 *
 * 通过CAS操作完成自旋锁，A 线程先进来调用 myLock 方法自己持有锁5秒钟，B 随后进来发现
 * 当前有线程持有锁，不是 null，所以只能通过自旋等待，直到 A 线程释放锁后 B 随后抢到
 *
 * @author: caibingqiang
 * @date: 2020-07-17 17:11
 * @version: V1.0
 */
public class SpinLockDemo {

    // 原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        // 当前进来的线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in ...");

        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        // 如果thread自己用完了，就变成null
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t invoked myUnlock()");
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(5); } catch(InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnlock();
        }, "AA").start();

        try { TimeUnit.SECONDS.sleep(1); } catch(InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(1); } catch(InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnlock();
        }, "BB").start();
    }

}
