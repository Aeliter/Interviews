package com.aeliter.zhongkeruan;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-28 9:27
 * @version: V1.0
 */
public class Example {

    public static void main(String[] args) {
        int var = 10;
        int var2 = 20;
        //System.out.println(var + var2++ + " " + var2);  // 30 21

        System.out.println(var + ++var2 + " " + var2);  // 31 21
    }

}
