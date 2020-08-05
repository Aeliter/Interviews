package com.aeliter.zhezhubang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 北京上玄笔试：请用JAVA代码实现，统计一篇英文文章单词个数
 * @author: caibingqiang
 * @date: 2020-03-10 23:42
 * @version: V1.0
 */
public class Test2 {

    public static void main(String[] args) {
        try {
            FileWordCount fwc = new FileWordCount();
            fwc.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            Integer times = 0;
            while(matcher.find()){		//是否匹配单词
                word = matcher.group();		//得到一个单词，树映射中的键
                n++;
                if( map.containsKey(word) ){	//如果该键存在，则表示单词出现过
                    times = map.get(word);		//得到单词出现的次数
                    map.put(word, times+1);
                } else {
                    map.put(word, 1);	//否则单词是第一次出现，直接放入map
                }
                map.put(word, 1);
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {

                @Override
                public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
                    return (left.getValue()).compareTo(right.getValue());
                }
            };
            Collections.sort(list, comparator);
            System.out.println("统计分析如下：");
            System.out.println("文章中单词总数" + n + "个");
            System.out.println("具体的信息在原文件目录的result.txt文件中");
            BufferedWriter bufw = new BufferedWriter(new FileWriter("D:\\result.txt"));
            for(Map.Entry<String, Integer> me : list){
                bufw.write(me+"");
                bufw.newLine();
            }
            bufw.write("english.txt中的单词总数" + n + "个");
            bufw.newLine();
            bufw.write("english.txt中不同单词" + map.size() + "个");
            bufw.close();
        }
    }

}
