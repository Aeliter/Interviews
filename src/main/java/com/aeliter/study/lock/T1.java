package com.aeliter.study.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-17 11:31
 * @version: V1.0
 */
public class T1 {

    volatile int n = 0;

    public void add() {
        n++;
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
    }

}
