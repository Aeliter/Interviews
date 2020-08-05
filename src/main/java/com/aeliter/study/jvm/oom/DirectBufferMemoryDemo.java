package com.aeliter.study.jvm.oom;

import java.nio.ByteBuffer;

/**
 * @description: java.lang.OutOfMemoryError: Direct buffer memory，NIO
 *
 * 配置参数：
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * 故障现象：
 * Exception in thread "main" java.lang.OutOfMemory Error: Direct buffer memory
 *
 * 导致原因：
 * 写NIO程序经常使用 ByteBuffer 来读取或者写入数据，这是一种基于通道（Channel）与缓存区（Buffer）的I/O方式，它可以使用 Native 函数库
 * 直接分配堆外内存，然后通过一个存储在Java堆里面的 DirectByteBuffer对象作为这块内存的引用进行操作。这样能在一些场景中显著提高性能，因为
 * 避免了在 Java 堆和 Native 堆中来回复制数据。
 *
 *    ByteBuffer. allocate(capability) 第一种方式是分配 JVM 堆内存，属于GC管辖范围，由于需要拷贝所以速度相较慢
 *    ByteBuffer. allocateDirect(capability) 第二种方式是分配 OS 本地内存，不属子GC管辖范围，由于不需要内存拷贝所以速度相对较快。
 *
 * 但如果不断分配本地内存，堆内存很少使用，那么 JVM 就不需要热执行GC, DirectByteBuffer象们就不会被回收，这时候堆内存充足，但本地内存可能
 * 已经使用光了，再次尝试分配本地内存就会出现0ut0fMemoryError，那程序就直接崩溃了。
 *
 * @author: caibingqiang
 * @date: 2020-07-25 10:46
 * @version: V1.0
 */
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory：" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        // 暂停一会儿线程
        try { Thread.sleep(3000); } catch(InterruptedException e) { e.printStackTrace(); }
        // -XX:MaxDirectMemorySize=5m   我们配置为5MB，但实际使用6MB，故意使坏
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

}
