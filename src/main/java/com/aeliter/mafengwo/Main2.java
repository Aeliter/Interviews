package com.aeliter.mafengwo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 用户活跃指数
 * @author 10473
 * 算法工程师在给用户推荐帖子时，需要对用户的活跃度进行分析，我们用一个正整数数组来表示一个用户在每个时间段内的活跃指数。例如：[6, 2, 5, 10]
 * 表示用户在4个连续时间段内的活跃指数分别为6、2、5、10，试找出该数组内乘积小于threshold的连续子数组的个数。
 * 
 * 输入：分为两行（均为字符串）：
 * 第一行：正整数数组，逗号分隔；
 * 第二行：阈值threshold。
 * 注意：你需要编写代码分别读入两行输入数据并解析为合适的数据结构
 * 输出：
 * 一个整数，用于表示乘积小于threshold的连续子数组的个数。
 * 
 * 样例输入：
 * 6,2,5,10
 * 100
 * 
 * 样例输出：
 * 8
 */
public class Main2 {
	
	public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        Integer input2 = Integer.valueOf(bufferedReader.readLine());
        String[] input = input1.split(",");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.valueOf(input[i]);
        }
        int result = test(array, input2);
        System.out.println(result);
    }
	
    public static int test(int[] array, Integer num) {
        if (num == 0) {
        	return 0;
        }
        int res = 0, prod = 1, left = 0;
        for (int i = 0; i < array.length; i++) {
            prod *= array[i];
            while (prod >= num && left <= i) {
            	prod /= array[left++];
            }
            res += (i - left + 1);
        }
        return res;
    }
	
}
