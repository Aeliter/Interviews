package com.aeliter.zhezhubang;

import java.io.StringWriter;

/**
 * @description: 北京上玄笔试：给你一组字符串如：7i8hy4jjnb2. 请编程输出里面的数字：7842
 * @author: caibingqiang
 * @date: 2020-03-10 23:28
 * @version: V1.0
 */
public class Test1 {
    public static void main(String[] args) {
        String str = "7i8hy4jjnb2";
        StringWriter stringWriter = new StringWriter();
        for (char c : str.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                stringWriter.write(c);
            }
        }
        String result = stringWriter.toString();
        System.out.println(result);
    }
}
