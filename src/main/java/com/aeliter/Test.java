package com.aeliter;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-06-27 13:11
 * @version: V1.0
 */
public class Test {

    public static void main(String[] args) {
        /**
         * true
         * false
         * true
         * true
         */
        /*Integer a = 100, b = 100, c = 150, d = 150;
        int e = 100, f = 100, g = 150, h = 150;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(g == h);*/

        /**
         * false
         */
        /*String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);*/

        for (int i = 0; i < 65536; i++) {
            if (i % 50 == 0) {
                System.out.println();
            }
            System.out.print((char)i);
        }

    }

}
