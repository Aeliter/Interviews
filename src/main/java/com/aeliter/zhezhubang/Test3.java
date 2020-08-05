package com.aeliter.zhezhubang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 北京上玄笔试：请用JAVA代码实现，统计一篇英文文章单词个数
 * @author: caibingqiang
 * @date: 2020-03-11 9:07
 * @version: V1.0
 */
public class Test3 {
    public static void main(String[] args) throws IOException {

        FileWordCount fileWordCount = new FileWordCount();
        fileWordCount.count();

    }

    // java实现读取英文文章，统计其中每个单词出现的次数并输出
    public static class FileWordCount {

        public void count() throws IOException{
            BufferedReader reader = new BufferedReader(new FileReader("D:\\cbq.txt"));
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while( (line = reader.readLine()) != null ){
                buffer.append(line);
            }
            reader.close();
            Pattern pattern = Pattern.compile("[a-zA-Z]+");	//定义正则表达式匹配单词
            String string = buffer.toString();
            Matcher matcher = pattern.matcher(string);
            Map<String, Integer> map = new TreeMap<String, Integer>();
            String word = "";
            int n = 0;
            while(matcher.find()){		//是否匹配单词
                word = matcher.group();		//得到一个单词，树映射中的键
                n++;
                map.put(word, 1);
            }
            System.out.println("文章中单词总数" + n + "个");
        }
    }
}
