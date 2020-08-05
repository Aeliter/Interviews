package com.aeliter.study.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:阻塞队列
 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序。
 * LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO（先进先出）排序元素，吞吐量要高于ArrayBlockingQueue。
 * SynchronousQueue：一个基于一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue。
 *
 * 1、队列
 * 2、阻塞队列
 *      2.1 阻塞队列有没有好的一面
 *
 *      2.2 不得不阻塞，你如何管理
 *
 * @author: caibingqiang
 * @date: 2020-07-18 14:55
 * @version: V1.0
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /**
         * 第一组：抛出异常
         * add(e)
         * remove()
         * element()
         */
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("x")); // Exception in thread "main" java.lang.IllegalStateException: Queue full

        System.out.println(blockingQueue.element()); // 检查是否为空并且拿出队首元素

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove()); // Exception in thread "main" java.util.NoSuchElementException*/

        /**
         * 第二组：特殊值
         * offer(e)
         * poll()
         * peek()
         */
        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("x")); // false

        System.out.println(blockingQueue.peek()); // 检查是否为空并且拿出队列顶端元素

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll()); // null*/

        /**
         * 第三组：阻塞
         * put(e)
         * take()
         */
        /*blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("==============================");
//        blockingQueue.put("x"); // 一直等待

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take(); // 一直等待*/

        /**
         * 第四组：超时
         * offer(e, time, unit)
         * poll(time, unit)
         */
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS)); // 2s之后，返回false

        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS)); // 2s之后，返回null

    }

}
