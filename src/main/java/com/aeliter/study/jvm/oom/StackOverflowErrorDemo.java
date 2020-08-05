package com.aeliter.study.jvm.oom;

/**
 * @description: Java.lang.StackOverflowError，是Error，深度方法调用导致出不来，栈爆了
 * @author: caibingqiang
 * @date: 2020-07-24 11:51
 * @version: V1.0
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }

}
