package com.aeliter.study.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 *
 * JVM参数：
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 *
 * Java8 及之后的版本使用 Metaspace 来替代水久代。
 *
 * Metaspace 是方法区在 HotSpot中的实现，它与持久代最大的区别在于：Metaspace 并不在虚拟机内存中,而是使用本地内存，也即在 Java8 中，
 * classe metadata(the virtual machines internal presentation of Java class)，被存储在叫做Metaspace 的 native memory
 * 永久代（Java8 后被元空间 Metaspace 取代了）存放了以下信息：
 *  1、虚拟机加载的类信息
 *  2、常量池
 *  3、静态变量
 *  4、即时编译后的代码
 *
 * 模拟 Metaspace空间溢出，我们不断生成类往元空间灌，类占据的空间总是会超 Metaspace指定的空间大小的
 *
 * @author: caibingqiang
 * @date: 2020-07-25 11:49
 * @version: V1.0
 */
public class MetaspaceOOMDemo {

    static class OOMTest {}
    public static void main(String[] args) {

        int i = 0;  // 模拟计数多少次以后发生异常
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("########## 多少次后发生了异常：" + i);
            e.printStackTrace();
        }
    }

}
