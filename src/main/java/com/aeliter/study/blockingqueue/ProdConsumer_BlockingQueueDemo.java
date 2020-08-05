package com.aeliter.study.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 资源类
 */
class MyResource {

    private volatile boolean FLAG = true; // 默认开启，进行生产 + 消费
    private AtomicInteger atomicInteger = new AtomicInteger(); // 默认值为0

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName()); // 反射打印类名、包名
    }

    /**
     * 生产者
     * @throws Exception
     */
    public void myProduct() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停了，表示FLAG=false，生产动作结束");
    }

    /**
     * 消费者
     * @throws Exception
     */
    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);

            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒钟没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }

            System.out.println(Thread.currentThread().getName() + "\t 消费队列蛋糕" + result + "成功");
        }
    }

    /**
     * 大老板叫停
     */
    public void stop() throws Exception {
        this.FLAG = false;
    }
}
/**
 * @description:
 *
 * volatile / CAS / AtomicInteger / BlockingQueue / 线程交互 / 原子引用
 *
 * @author: caibingqiang
 * @date: 2020-07-19 11:30
 * @version: V1.0
 */
public class ProdConsumer_BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new LinkedBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.myProduct();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Product").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.myConsumer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(5); } catch(InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5秒钟时间到，大老板main叫停，活动结束");

        myResource.stop();
    }

}
