package com.aeliter.study.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 *
 * 第四种获得/使用java多线程的方式：线程池
 *
 * @author: caibingqiang
 * @date: 2020-07-21 9:02
 * @version: V1.0
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        /**
         * 线程池的手写改造和拒绝策略
         */
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

    /**
     * JDK版
     */
    public static void threadPoolInit() {
        // 查看底层CPU的核数
//        System.out.println(Runtime.getRuntime().availableProcessors());

        // Array        Arrays
        // Collection   Collections
        // Executor     Executors
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 一池5个处理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); // 一池N个处理线程

        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                // 暂停一会儿线程
                try { TimeUnit.MILLISECONDS.sleep(200); } catch(InterruptedException e) { e.printStackTrace(); }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
