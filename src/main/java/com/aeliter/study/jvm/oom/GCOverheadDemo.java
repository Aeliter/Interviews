package com.aeliter.study.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: GC overhead limit exceeded
 *
 * JWM参数配萱演
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * GC回收时间过长时会抛出Out0fMemoryError。过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存，
 * 连续多次GC都只回收了不到2%的极端情况下才会抛出。假如不抛出 GC overhead limit错误会发生什么情况呢？
 * 那就是GC清理的这么点内存很快会再次填满，迫使GC再次的执行。这样就形成恶性循环，
 * CPU使用率一意是100%，GC却没有任何成果。
 *
 * @author: caibingqiang
 * @date: 2020-07-25 7:56
 * @version: V1.0
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("##########i：" + i);
            e.printStackTrace();
            throw e;
        }

    }

}
