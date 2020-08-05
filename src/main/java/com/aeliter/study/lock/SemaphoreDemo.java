package com.aeliter.study.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: Semaphore
 * @author: caibingqiang
 * @date: 2020-07-18 13:49
 * @version: V1.0
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // Semaphore(int permits, boolean fair)
        Semaphore semaphore = new Semaphore(3); // 模拟三个停车位

        for (int i = 1; i <= 6; i++) { // 模拟六部汽车
            new Thread(() -> {
                try {
                    // 抢到资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    // 暂停一会儿线程
                    try { TimeUnit.SECONDS.sleep(3); } catch(InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放资源
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }

}
