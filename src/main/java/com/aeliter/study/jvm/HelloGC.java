package com.aeliter.study.jvm;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-22 23:26
 * @version: V1.0
 */
public class HelloGC {

    public static void main(String[] args) throws Exception {

        /*long totalMemory = Runtime.getRuntime().totalMemory(); // 返回 java 虚拟机中的总量
        long maxMemory = Runtime.getRuntime().maxMemory(); // 返回 java 虚拟机中试图使用的最大内存
        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "（字节）" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + totalMemory + "（字节）" + (maxMemory / (double)1024 / 1024) + "MB");*/

        System.out.println("******HelloGC");
//        byte[] byteArray = new byte[50 * 1024 * 1024];
        Thread.sleep(Integer.MAX_VALUE);

    }

}
