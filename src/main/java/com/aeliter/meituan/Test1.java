package com.aeliter.meituan;

import java.util.Scanner;

/**
 * 描述：有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：
 *      1． 向右走一格，即从(x,y)到(x,y+1);
 *      2． 向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);
 *      3． 向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);
 * 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。
 *
 * 输入：输入第一行仅包含一个正整数n，表示网格的长度。(1<=n<=50)，接下来有2行,每行有n个字符，“X”代表障碍物，“.”代表可以停留。
 *
 * 输出：如果没有可以到达的路线则输出-1，否则输出方案数量。
 */
public class Test1 {
    public int count(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] result = new int[m][n];

        //内存迭代搜索
        for (int index = 0; index < m; index++) {
            result[index][0] = 1;
        }
        for (int index = 0; index < n; index++) {
            result[0][index] = 1;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];

            }
        return result[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("row: ");
        int m = in.nextInt();
        System.out.println("columns: ");
        int n = in.nextInt();
        int[][] rawArr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                rawArr[i][j] = in.nextInt();
            }
        Test1 test1 = new Test1();
        int count = test1.count(rawArr);
        System.out.println("count: " + count);
        in.close();

    }
}
