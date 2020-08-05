package com.aeliter.study.lock;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(2); } catch(InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获得：" + lockA);
            }
        }
    }
}
/**
 * @description:
 *
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，
 * 若无外力干涉那它们都将无法推进下去，如果系统资源充足，进程的资源请求都能够得到满足，
 * 死锁岀现的可能性就很低，否则就会因争夺有限的资源而陷入死锁。
 *
 * @author: caibingqiang
 * @date: 2020-07-22 17:29
 * @version: V1.0
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();

    }

}
