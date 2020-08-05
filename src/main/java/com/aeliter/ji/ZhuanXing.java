package com.aeliter.ji;

import java.util.Scanner;

public class ZhuanXing {
	
	public void convert(int number) {
		//数字对应的汉字
		String[] num = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
		//单位
		String[] unit = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万"};
		//将输入数字转换为字符串
		String result = String.valueOf(number);
		//将该字符串分割为数组存放
		char[] ch = result.toCharArray();
		//结果 字符串
		String str = "";
		int length = ch.length;
		for (int i = 0; i < length; i++) {
			int c = (int)ch[i]-48;
			if(c != 0) {
				str += num[c]+unit[length-i-1];
			} else {
				str += num[c];
			}
		}
		System.out.println(str);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("请输入要进行转换的数字......");
			String str = scanner.next();
			if("-1".equals(str))
				return;
			new ZhuanXing().convert(Integer.parseInt(str));
		}
	}

}
