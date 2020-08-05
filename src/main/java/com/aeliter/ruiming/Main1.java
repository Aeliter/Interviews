package com.aeliter.ruiming;

import java.lang.Math;

/**
 * 背包问题
 * 描述：将军在外大胜而归，国王除了给将军加封之外，还要赏赐将军一批礼物。这批礼物的重量分别是：2, 2, 6, 5, 4，对应的价值分别是：6, 3, 5, 4, 6。
 * 但是将军的马车载重是有限的，最大载重是10。聪明的将军想拿到的礼物价值最大，并且马车还能拉走。请问将军能拿到的礼物的最大价值是多少，并编写代码
 * 实现求解过程
 *
 * 输入描述：无
 *
 * 输出描述：将军能拿到的礼物的最大价值
 */
public class Main1 {

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};
        System.out.println("将军能拿到的礼物的最大价值为：" + knapSack(w, v, 10));
    }

    private static int solveKS(int[] w, int[]v, int index, int capacity) {
        if(index < 0 || capacity <= 0) {
            return 0;
        }
        int res = solveKS(w, v, index - 1, capacity);
        if(w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }
        return res;
    }

    public static int knapSack(int[] w, int [] v, int C) {
        int size = w.length;
        return solveKS(w, v, size - 1, C);
    }

}