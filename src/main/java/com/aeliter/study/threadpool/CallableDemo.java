package com.aeliter.study.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ****** come in Callable");
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(3); } catch(InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }

}
/**
 * @description:
 *
 * 多线程中，第三种获得多线程的方式
 *
 * @author: caibingqiang
 * @date: 2020-07-19 16:19
 * @version: V1.0
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 两个线程，一个是main，一个是AA的futureTask

        // FutureTask(Callable<V> callable)
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());

        new Thread(futureTask, "AA").start();
        new Thread(futureTask2, "BB").start();

        System.out.println(Thread.currentThread().getName() + "\t **********");
        int result01 = 100;

        while (!futureTask.isDone()) {

        }

        // get是要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成建议放在最后
        int result02 = futureTask.get();

        System.out.println("****** result：\t" + (result01 + result02));

        // Thread(Runnable target, String name);      Allocates a new Thread object.

    }

}
