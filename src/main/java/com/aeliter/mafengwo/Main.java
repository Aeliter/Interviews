package com.aeliter.mafengwo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 寻找机票价格峰值
 * @author 10473
 * 机票价格受订票日期、出行日期以及是否节假日等多因素影响，为提升用户体验，会对一段时间内的价格峰值（其值大于或小于左右相邻元素）进行特殊标识，给定一个价格数组
 * flightPrices，其中flightPrices[i]不等于flightPrices[i+1]，找到峰值价格并返回索引，数组可能包含多个峰值价格，需要全部返回，时间
 * 复杂度尽可能小
 * 
 * 输入：
 * 输入机票价格数组
 * 输出：
 * 返回价格峰值索引数组
 * 
 * 样例输入：
 * 输入：【490, 300, 445, 1200, 1300, 900】
 * 
 * 样例输出：
 * 1
 * 4
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String readLine1 = bf.readLine();
        String[] split1 = readLine1.split("输入：【");
        String[] split2 = split1[1].split("】");
        String[] splitNumber = split2[0].split("， ");
        int[] array = new int[splitNumber.length];
        for (int i = 0; i < splitNumber.length; i++) {
            array[i] = Integer.valueOf(splitNumber[i]);
        }
        getMinAndMax(array);
    }
    public static void getMinAndMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i])
                min = array[i];
            if (max < array[i])
                max = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
	
	/*public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();
		String[] split1 = input.split("输入：【");
        String[] split2 = split1[1].split("】");
        String[] num = split2[0].split(", ");
		int[] res = new int[num.length];
		for (int j = 0; j < num.length; j++) {
			res[j] = Integer.parseInt(num[j]);
		}
		num = null;
		
		System.out.println(getMin(res));
		System.out.println(getMax(res));
	}
	
	public static int getMax(int[] arr) {
        int maxIndex=0;; 
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
	
	public static int getMin(int[] arr){
        int minIndex=0;; 
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }*/
	
}
