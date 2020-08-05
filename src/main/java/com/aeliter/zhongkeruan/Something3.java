package com.aeliter.zhongkeruan;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-28 9:33
 * @version: V1.0
 */
public class Something3 {

    public static void main(String[] args) {
        Other o = new Other();
        new Something3().addOne(o);
    }

    public void addOne(final Other o) {
        o.i++;
    }

}
class Other {
    public int i;
}
