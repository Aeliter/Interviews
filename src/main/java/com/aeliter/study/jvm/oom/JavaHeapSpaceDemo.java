package com.aeliter.study.jvm.oom;

/**
 * @description:  Java.lang.OutOfMemoryError:Java heap space，是Error，对象太多，堆爆了
 * @author: caibingqiang
 * @date: 2020-07-24 11:54
 * @version: V1.0
 */
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {

        byte[] bytes = new byte[80 * 1024 * 1024];

        /*String str = "Aeliter";

        while (true) {
            str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
            str.intern();
        }*/

    }

}
