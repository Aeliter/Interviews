package com.aeliter.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 *  可重入锁（也叫做递归锁）：
 *
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁，
 *
 * 也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 * @author: caibingqiang
 * @date: 2020-07-17 16:19
 * @version: V1.0
 */
class Phone implements Runnable {

    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t ######invoked sendEmail()");
    }

    // ========================================

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        lock.lock();
        try {
            // 线程可以进入任何一个它已经拥有的锁
            //所同步着的代码块
            System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t invoked get()");
            set();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t invoked set()");
        } finally {
            lock.unlock();
        }
    }

}

/**
 * case 1：synchronized 就是一个典型的可重入锁
 *
 * t1	11	 invoked sendSMS()          同一线程外层函数获得锁之后
 * t1	11	 ######invoked sendEmail()  在进入内层方法会自动获取锁
 * t2	12	 invoked sendSMS()
 * t2	12	 ######invoked sendEmail()
 *
 * case 2：ReentrantLock 就是一个典型的可重入锁
 * Thread-0	13	 invoked get()
 * Thread-0	13	 invoked set()
 * Thread-1	14	 invoked get()
 * Thread-1	14	 invoked set()
 */
public class ReentrantLockDemo {

    public static void main(String[] args) throws Exception {

        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(1); } catch(InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();

    }

}
