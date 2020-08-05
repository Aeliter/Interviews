package com.aeliter.zantong;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-27 10:41
 * @version: V1.0
 */
public class Test1 {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println("str1 = " + str1 + ", str2 = " + str2);
        System.out.println(str1 == str2);
    }

}
