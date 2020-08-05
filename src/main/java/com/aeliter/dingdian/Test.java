package com.aeliter.dingdian;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-06-23 10:20
 * @version: V1.0
 */
public class Test {

    public int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            System.out.println("catch语句块");
        }
        finally {
            System.out.println("finally语句块");
        }
        return 0;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("和是：" + test.add(9, 34));
    }

}
