package com.aeliter.zhongkeruan;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-28 9:38
 * @version: V1.0
 */
public class JieCheng {

    public static void main(String[] args) { //java程序的主入口处
        int num = 5;
        int num1 = 23;
        System.out.println("简单的循环计算" + num + "的阶乘为：" //调用simpleCircle
                + simpleCircle(num));
        System.out.println("利用递归计算" + num + "的阶乘为："  //调用recursion
                + recursion(num));
        System.out.println("数组添加计算" + num + "的阶乘为："  //调用addArray
                + addArray(num));
        System.out.println("利用BigInteger类计算" + num + "的阶乘为："//调用bigNumber
                + bigNumber(num1));

    }

    /**
     * 1.使用递归方式实现
     *
     * @param num
     * @return
     */
    public static int recursion(int num) { //利用递归计算阶乘
        int sum = 1;
        if (num < 0) {
            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
        }
        if (num == 1) {
            return 1;   //根据条件,跳出循环
        } else {
            sum = num * recursion(num - 1); //运用递归计算
            return sum;
        }
    }

    /**
     * 2.使用循环方式实现
     */
    public static int simpleCircle(int num) {    //简单的循环计算的阶乘
        int sum = 1;
        if (num < 0) {  //判断传入数是否为负数
            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
        }
        for (int i = 1; i <= num; i++) {    //循环num
            sum *= i;   //每循环一次进行乘法运算
        }
        return sum; //返回阶乘的值
    }


    /**
     * 3. 利用数组添加计算
     */
    public static long addArray(int num) {  //数组添加计算阶乘
        long[]arr = new long[21];   //创建数组
        arr[0] = 1;
        int last = 0;
        if(num >= arr.length) {
            throw new IllegalArgumentException("传入的值太大");   //抛出传入的数太大异常
        }
        if(num < 0) {
            throw new IllegalArgumentException("必须为正整数!");  //抛出不合理参数异常
        }
        while(last < num) { //建立满足小于传入数的while循环
            arr[last + 1] = arr[last] * (last + 1); //进行运算
            last++; //last先进行运算，再将last的值加1
        }
        return arr[num];
    }
    /**
     * 4.利用BigInteger类计算
     */
    public static synchronized BigInteger bigNumber(int num) {  //利用BigInteger类计算阶乘
        ArrayList list = new ArrayList();   //创建集合数组
        list.add(BigInteger.valueOf(1));    //往数组里添加一个数值
        for (int i = list.size(); i <= num; i++) {
            BigInteger lastfact = (BigInteger) list.get(i - 1); //获得第一个元素
            BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(i)); //获得下一个数组
            list.add(nextfact);
        }
        return (BigInteger) list.get(num);//返回数组中的下标为num的值
    }

}


