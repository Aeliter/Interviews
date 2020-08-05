package com.aeliter.wanmeishijie;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-04-14 19:18
 * @version: V1.0
 */
public class Demo {

    private static final String INC = "PerfectWorld";

    public static void main(String[] args) {
        String a = "Perfect" + "World";
        String b = "Perfect";
        String c = "World";
        System.out.println(a == INC);
        System.out.println((b + c) == INC);
    }

}
