package com.aeliter.study.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 资源类
class MyCache {

    private volatile Map<String, Object> map= new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 1. 写
    public void put(String key, Object value) {
        // 读写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            // 模拟网络延时拥堵
            try { TimeUnit.MICROSECONDS.sleep(300); } catch(InterruptedException e) { e.printStackTrace(); }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    // 2. 读
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：");
            // 模拟网络延时拥堵
            try { TimeUnit.MICROSECONDS.sleep(300); } catch(InterruptedException e) { e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    // 3. 缓存清空
    public void clearMap() {
        map.clear();
    }

}
/**
 * @description: 读写锁
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源类，就不应该有其他线程可以对资源进行读或写
 *
 * 小总结:
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 *
 *      写操作：原子+独占，整个过程必须是一个完整的统一体，中间不允许被分割、被打断。
 * @author: caibingqiang
 * @date: 2020-07-18 7:47
 * @version: V1.0
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        // 线程操作资源类
        MyCache myCache = new MyCache();

        // 写操作
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        // 读操作
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }

}
