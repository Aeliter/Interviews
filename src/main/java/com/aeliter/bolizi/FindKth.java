package com.aeliter.bolizi;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-06-29 17:36
 * @version: V1.0
 */
public class FindKth {

    public static int findKth(int[] arr,int k) {

        // 对数组进行排序
        if(arr != null) {
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = 0; j < arr.length-1-i; j++) {
                    if(arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
        // 思路就是直接从排序的数组中找奇数
        // 我们遍历数组，这个a就是第几个小的奇数，然后每次都与k比较，如果是就返回
        int a = 1;
        for (int i = 0; i < arr.length; i++) {
            // 说明是个奇数
            if(arr[i] % 2 == 1) {
                // 如果第a小的数是想要k，那么就可以返回了
                if(a == k) {
                    return arr[i];
                }
                a++;
            }
        }
        // 返回结果
        return 0;
    }

    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = {11,9,5,13,7,3,6,1,16};
        // 调用定义好的排序方法
        System.out.println(findKth(arr,4));
    }

}
