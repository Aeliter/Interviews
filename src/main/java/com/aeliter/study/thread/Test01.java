package com.aeliter.study.thread;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-06-30 21:55
 * @version: V1.0
 */
public class Test01 {

    volatile int n = 0;
    public void add() {
        n++;
    }

}
