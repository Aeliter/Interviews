package com.aeliter.zhongkeruan;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-28 9:20
 * @version: V1.0
 */
public class Check {

    public static void main(String[] args) {
        String s = "12";
        Demo dec = new Demo();
        dec.append(s);
        System.out.println(s);  // 12
    }

}

class Demo {
    public void append(String s) {
        s = s + "1";
    }
}
