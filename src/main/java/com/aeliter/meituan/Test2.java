package com.aeliter.meituan;

import java.util.Scanner;

/**
 * 描述：给出一个序列包含n个正整数的序列A，然后给出一个正整数x，你可以对序列进行任意次操作的，每次操作你可以选择序列中的一个数字，
 * 让其与x做按位或运算。你的目的是让这个序列中的众数出现的次数最多。请问众数最多出现多少次。
 *
 * 输入：输入第一行仅包含两个正整数n和x，表示给出的序列的长度和给定的正整数。(1<=n<=100000,1<=x<=1000)
 *      接下来一行有n个正整数，即这个序列，中间用空格隔开。(1<=a_i<=1000)
 *
 * 输出：输出仅包含一个正整数，表示众数最多出现的次数。
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String s = input.nextLine();
        String[] split = s.split(" ");
        Integer[] nums = new Integer[split.length];
        int max = 0;
        int count = 0;
        for(int i = 0; i < split.length; i++) {
            Integer ss = new Integer(split[i]);
            max = nums[0];
            nums[i] = ss;
            if (max == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    max = nums[i];
                    count++;
                }
            }
        }
        System.out.println(max);
    }

}
    /*public int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 0;
        int max = nums[0];

        for(int i = 1; i < len; i++){
            if(max == nums[i]){
                count++;
            }else{
                count--;
                if(count == 0){
                    max = nums[i];
                    count++;
                }
            }
        }
        return max;
    }*/