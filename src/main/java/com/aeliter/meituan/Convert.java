package com.aeliter.meituan;

import java.util.Scanner;

/**
 * 数字转换问题
 * @author 10473
 * 
 * 题目描述：
美团点评商家端系统里，客户在商家店里消费完成后，需要开消费发票。在开据消费发票过程中需需要将阿拉伯数字转成中文大写数字。举例来说：200.00需要转换成贰佰元整。现需要通过程序实现转换功能，以提升商家开发票的效率。

输入
一维的字符串数组，数组里每一项为阿拉伯数字，数字保留两位小数点且最大值不超过1000000000000（万亿）；输入示例（注意：数组符[]也为输入项）：["200.00", "201.15"]

输出
转换后对应的一维数组；


样例输入
["200.00","201.15","1015","200001010200"]
样例输出
["贰百元整", "贰百零壹元壹角伍分", "壹千零壹十伍元整", "贰千亿零壹百零壹万零贰百元整"]

提示
1. 单位参考：壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整；
2. 当数据为整数值或者小数部分为零时，需要添加XX元整。如：10表示为壹十元整， 200.00表示为贰百元整；
 *
 */
public class Convert {
	public void convert(int number) {
		//数字对应的汉字
		String[] num = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		//单位
		String[] unit = {"元","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","万"};
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
			new Convert().convert(Integer.parseInt(str));
		}
		
	}

}

