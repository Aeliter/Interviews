package com.aeliter.study.thread;

/**
 * @description: 有序性，重排2
 * @author: caibingqiang
 * @date: 2020-06-30 22:47
 * @version: V1.0
 */
public class ReSortSeqDemo {

    int a = 0;
    boolean flag = false;

    public void method01() {
        a = 1;
        flag = true;
    }

    public void method02() {
        if (flag) {
            a = a + 5;
            System.out.println("*****retValue: " + a);
        }
    }

}
