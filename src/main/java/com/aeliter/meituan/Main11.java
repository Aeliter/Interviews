package com.aeliter.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-03-12 19:49
 * @version: V1.0
 */
public class Main11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] s1 = s.split(" ");


        int[] ary = {3, 3, 3, 2, 7};
        int[] a = ary2num(ary);
        System.out.println("众数及其重数为：" + a[findmax(count(ary,a))]
                /*+ ";" + count(ary,a)[findmax(count(ary,a))]*/);
    }
    //ary2num:实现由若干个个自然数的集合到其中所含自然数种类集合的方法（去除重复出现的自然数）。
    static int[] ary2num(int[] ary){
        int[] num_1 = new int[ary.length];
        int n =0;
        int yes = 0;//yes为0时，表示之前尚未出现该自然数，录入num_1
        for(int i = 0;i < ary.length;i++) {
            for (int j = 0; j < num_1.length; j++) {
                if (ary[i] == num_1[j]){
                    yes = 1;
                    break;
                }
            }
            if(yes == 0) {
                num_1[n] = ary[i];
                n++;
            }
            yes = 0;
        }
        //System.out.println(n);
        //去掉num_1数组中的0
        int[] num = new int[n];
        for(int i = 0;i < n;i++) {
            num[i] = num_1[i];
        }
        return num;
    }

    //对num数组中的各个自然数的重数做统计
    static int[] count(int[] array,int[] num) {
        int[] count = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j] == num[i]) {
                    count[i]++;
                }
            }
        }
        return count;
    }
    //寻找count中的最大值,返回最大值索引
    static int findmax(int[] array) {
        int max_index = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i+1] > array[i]) {
                max_index = i+1;
            }
        }
        return max_index;

    }

}
