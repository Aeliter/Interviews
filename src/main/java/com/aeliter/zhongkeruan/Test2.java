package com.aeliter.zhongkeruan;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-28 10:52
 * @version: V1.0
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(isNumericZidai("hsgdabda8igfga"));
    }

    public static boolean isNumericZidai(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
