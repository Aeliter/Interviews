package com.aeliter.meituan;

import java.util.Scanner;

/**
 * 给出两个字符串，分别是模式串P和目标串T，判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0。模式串中
 * ‘？’可以匹配目标串中的任何字符，模式串中的 ’*’可以匹配目标串中的任何长度的串，模式串的其它字符必须和目
 * 标串的字符匹配。例如P=a?b，T=acb，则P 和 T 匹配。
 */
public class Main2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String s = sc.next();
        // System.out.println(s + " - " + p);
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        System.out.println((dp[m][n] ? 1 : 0));
    }

}
