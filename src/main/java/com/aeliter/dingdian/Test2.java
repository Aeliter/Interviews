package com.aeliter.dingdian;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-06-23 10:24
 * @version: V1.0
 */
public class Test2 {

    public static void main(String[] args) {
        int result;
        int a = 17, b = 6;
        result = (a % b > 4) ? a % b : a / b;
        System.out.println(result);
    }

}
