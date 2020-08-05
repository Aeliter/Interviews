package com.aeliter.ruiming;

/**
 * @description:
 * 描述：月球到地球的距离为384000KM，有一个数组a[384000]存放了384000个数，这384000个数取自2-384000，其中有且仅有两个数是相同的，
 * 请写出一个搜索算法找出那两个相同的数的值（注意空间效率和时间效率尽可能优化）
 *
 * 输入描述：a[384000]
 *
 * 输出描述：相同的数的数值
 */
public class Main2 {

    public static void main(String[] args) {

    }

    /*public int GetTheExtraVal(char var, int size) {
        int val;
        int i = 0;
        for (; i < size; ++i) {
            if (var[var[i]])
        }
        return val;
    }*/

    /*#include<stdio.h>
    #include<stdlib.h>

    int GetTheExtraVal(char*var, int size) {
        int val;
        int i = 0;
        for (; i < size; ++i) {
            if (var[var[i] & 0x7F] & 0x80)//字节最高位先前已经被置为1，说明脚标对应的数字重复
            {
                val = var[i] & 0x7F;     //取出重复的数
                break;
            }
            var[var[i] & 0x7F] |= 0x80;//将字节最高位置为1
        }
        for (; i >= 0; --i) {
            var[var[i] & 0x7F] &= 0x7F;//把字节最高位置过为1的清零，回到数组原来的状态
        }
        return val;
    }

    *//*测试程序*//*
    int main() {
        char num[ 100];
        int i;
        for (i = 0; i < 99; i++)
            num[i] = i + 1;
        num[i] = 5;
        char dulpval = GetTheExtraVal(num, 100);
        printf("%d\n", dulpval);
        return 0;
    }*/

}
