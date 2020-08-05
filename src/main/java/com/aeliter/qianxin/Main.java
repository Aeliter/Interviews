package com.aeliter.qianxin;

import java.util.Scanner;

/**
 * 
 * @author 10473
 * 
 * 题目描述：
 * 输入一行字符串，求里面不含有重复字符的最长子串。
 * 比如输入字符串为：aaabbacccc，可以从任意位置开始截取子字符串，这些子字符串中，不含有重复字符的最长子字符串是bac，它的长度是3。
 * 
 * 输入    字符串
 * 输出    不含有重复字符的最长子串长度
 * 样例输入    bcdbcdee
 * 样例输出    4
 * 
 */
public class Main {
	
	/*public static int max_length_substring(String _s) {
        int resLength = 0;
        int strLength = _s.length();
        for (int i = 0; i < strLength; i++) {
            for (int j = i + 1; j < strLength; j++) {
                //这里能确定_s的所有子串
                HashSet<String> hashSet = new HashSet<String>();
                Boolean isExists = false;
                for (int z = i; z < j; z++) {
                    String strChildren = _s.substring(z);
                    if (hashSet.contains(strChildren)) {
                        isExists = true;
                        break;
                    } else {
                        hashSet.add(strChildren);
                    }
                }
                if (!isExists) {
                    //这里是不存在相同的才给resLength赋值
                    resLength = Math.max(resLength, j - i);
                }
            
            }
        }
        return resLength;
    }*/
	public static int max_length_substring(String _s) {
        int[] hash = new int [500];
        int resLength = 0;
        int i = 0, j = 0;
        
        while (i < _s.length() && j < _s.length()) {
            if(hash[_s.charAt(j)] == 0) {
                hash[_s.charAt(j)] = 1;
                j++;
                resLength = (j - i) > resLength ? (j - i) : resLength;
            } else {
                hash[_s.charAt(i)] = 0;
                i++;
            }  
        }
        return resLength; 
    }
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
  
        res = max_length_substring(_s);
        System.out.println(String.valueOf(res));    
        
    }
	
}
