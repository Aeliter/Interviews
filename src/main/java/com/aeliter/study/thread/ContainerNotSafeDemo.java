package com.aeliter.study.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description: 集合类不安全的问题 ArrayList
 * @author: caibingqiang
 * @date: 2020-07-16 18:19
 * @version: V1.0
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());//new ConcurrentHashMap<>();//new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName() ,UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    public static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
        new HashSet<>();
    }

    public static void listNotSafe() {
        /*List<String> list = Arrays.asList("a", "b" ,"c");
        list.forEach(System.out::println);*/
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>()); //new Vector<>();//new ArrayList<>();

        // 线程不安全并发修改的异常：java.util.ConcurrentModificationException
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        /**
         * 1. 故障现象
         *      java.util.ConcurrentModificationException
         * 2. 导致原因
         *      并发争抢修改导致，参考花名册签名情况，一个人正在写入，另外一个同学过来抢夺，导致数据不一致异常，并发修改异常。
         * 3. 解决方案
         *    3.1 new Vector<>()
         *    3.2 Collections.synchronizedList(new ArrayList<>());
         *    3.3 new CopyOnWriteArrayList<>();
         * 4. 优化建议
         *
         */
        /**
         * 笔记：
         * 写时复制 copyOnWrite 容器即写时复制的容器。往容器添加元素的时候，不直接往当前容器object[]添加，而是先将当前容器object[]进行 copy，
         * 复制出一个新的object[] newElements，然后向新容器object[] newElements 里面添加元素，添加元素后，再将原容器的引用指向新的容器
         * setArray(newElements);这样的好处是可以对 copyOnWrite 容器进行并发的读，而不需要加锁，因为当前容器不会添加任何容器.所以copyOnWrite
         * 容器也是一种读写分离的思想，读和写不同的容器。
         *  public boolean add(E e) {
         *      final ReentrantLock lock = this.lock;
         *      lock.lock();
         *      try {
         *          Object[] elements = getArray();
         *          int len = elements.length;
         *          Object[] newElements = Arrays.copyOf(elements, len + 1);
         *          newElements[len] = e;
         *          setArray(newElements);
         *          return true;
         *      } finally {
         *          lock.unlock();
         *      }
         *  }
         */}

}