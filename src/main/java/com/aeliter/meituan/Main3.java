package com.aeliter.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 打车派单场景, 假定有N个订单， 待分配给N个司机。每个订单在匹配司机前，会对候选司机进行打分，打分的结果保存在N*N的矩阵A，其中
 * Aij 代表订单i司机j匹配的分值。假定每个订单只能派给一位司机，司机只能分配到一个订单。求最终的派单结果，使得匹配的订单和司机的
 * 分值累加起来最大，并且所有订单得到分配。
 */
public class Main3 {

    private double t = 0.00;
    private int[] flag;
    private double res = 0.00;
    private ArrayList<Integer> add;

    public void Solution(double[][] nums) {
        int n = nums.length;
        flag = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i + 1);
            flag[i] = 1;
            t += nums[0][i];
            Best(temp, nums, 1);
            t = 0.00;
            flag[i] = 0;
        }
        System.out.println(String.format("%.2f", res));
        for (int i = 0; i < add.size(); i++) {
            System.out.println(i + 1 + " " + add.get(i));
        }
    }

    public void Best(ArrayList<Integer> temp, double[][] nums, int end) {
        if (end == nums.length) {
            if (res < t) {
                res = t;
                add = (ArrayList<Integer>) temp.clone();
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] != 1) {
                flag[i] = 1;
                t += nums[end][i];
                temp.add(i + 1);
                Best(temp, nums, end + 1);
                temp.remove(temp.size() - 1);
                t -= nums[end][i];
                flag[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            double[][] nums = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = in.nextDouble();
                }
            }
            Main3 s = new Main3();
            s.Solution(nums);
        }
    }

}
