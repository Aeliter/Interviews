package com.aeliter.xiaomi;

import java.util.Scanner;

public class Demo01 {
	
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] num = new int[n][n];
        int[][] num2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = scanner.nextInt();
            }
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (num[i][j] != 0) {
                    num2[i][k++] = num[i][j];
                }
            }
            int flag = 4;
            while (flag-- != 0) {
                swap(n, num2, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(num2[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void swap(int n, int[][] num2, int i) {
        for (int j = 1; j < n; j++) {
            if (num2[i][j] == num2[i][j-1]) {
                num2[i][j-1] *= 2;
                num2[i][j] = 0;
            }
        }
    }
}
