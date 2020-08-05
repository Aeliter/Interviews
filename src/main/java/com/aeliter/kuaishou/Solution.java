package com.aeliter.kuaishou;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

	public static int calArithmeticSequence(int[] nums){
        int length = nums.length;
        if(length == 0) return 0;
        Arrays.sort(nums);
        /**
         * 最大等差
         */
        int diffMax = nums[length - 1] - nums[0];
        /**
         * dp数组保存每次遍历的结果
         */
        int[][] dp = new int[length][diffMax + 1];
        /**
         * 因为任何单个数，等差无论多少，长度初始化都为1
         */
        for(int i = 0; i < length; i++)
            for(int j = 0; j <= diffMax; j++)
                dp[i][j] = 1;
        int longestLength = 1;
        for(int i = 1; i < length; i++)
            /**
             * 依次考察i之前的数，对于每个j与i的差值temp
             * 都要对dp[i][temp] = dp[j][temp] + 1
             * 然后在看看当前的长度是否大于max,若大于max,则更新max值。
             */
            for(int j = i - 1; j >= 0; j--){
                int temp = nums[i] - nums[j];
                dp[i][temp] = dp[j][temp] + 1;
                longestLength = Math.max(longestLength, dp[i][temp]);
            }
        return longestLength;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        /**
         * 随机生成你想要多少个数
         */
        Random random = new Random();
        for(int i = 0; i < n; i++)
            nums[i] = random.nextInt(1000000);
        // int[] nums = {3,8,4,5,6,2};
        int length = calArithmeticSequence(nums);
        System.out.println(length);
    }

}
