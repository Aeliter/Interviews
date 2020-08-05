package com.aeliter.study.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 资源类 */
class ShareData {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 加操作
     */
    public void increment() throws Exception {

        lock.lock();
        try {
            // 1、判断
            while (number != 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2、干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3、通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 减操作
     */
    public void decrement() throws Exception {

        lock.lock();
        try {
            // 1、判断
            while (number == 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2、干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3、通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
/**
 * @description:
 *
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 *
 * 1、线程 操作（方法） 资源类
 * 2、判断 干活 唤醒通知
 * 3、防止虚假唤醒机制
 * @author: caibingqiang
 * @date: 2020-07-18 22:20
 * @version: V1.0
 */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {

        ShareData shareData = new ShareData();

        /**
         * AA 线程生产
         */
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        /**
         * BB 线程消费
         */
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

    }

}
