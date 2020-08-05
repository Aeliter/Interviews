package com.aeliter.zhezhubang; /**
 * @description:
 * @author: caibingqiang
 * @date: 2020-03-10 18:43
 * @version: V1.0
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void Count(File file){
        String str ="";
        String result = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while((str = bufferedReader.readLine())!=null){
                result = result+str;
            }
            bufferedReader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(result);
        Map<String, Integer> map = new HashMap<String, Integer>();
        Pattern p = Pattern.compile("[, . ; ! ? ]");
        Matcher m = p.matcher(result);
        String [] strs = p.split(result);
        for(int i=0;i<strs.length;i++){
            if(map.containsKey(strs[i])){
                int c = map.get(strs[i]);
                c++;
                map.put(strs[i], c);
            }
            else{
                map.put(strs[i], 1);
            }
        }
        Set set = map.entrySet();
        Iterator it = set.iterator();
        int min = 100;
        int max = 0;
        String minWord = "";
        String maxWord = "";
        int x = 0;
        while (it.hasNext()) {
            Entry<String, Integer> me = (Entry) it.next();
            if((int) me.getValue()<min&&!((String) me.getKey()).equals("")){
                min = (int) me.getValue();
                minWord = (String) me.getKey();
            }
            if((int) me.getValue()>=max&&!((String) me.getKey()).equals("")){
                max = (int) me.getValue();
                maxWord = (String) me.getKey();
            }
            System.out.println(me.getKey()+":"+me.getValue());
        }
        System.out.println("出现次数最多的是"+":"+max+"   "+maxWord);
    }

    private void println(Map map){
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Entry<String, Integer> entry = (Entry<String, Integer>) it.next();
            String key = entry.getKey();
            int value = entry.getValue();
        }
    }

    public static void main(String[] args){
        File file = new File("C:/Users/Administrator/Desktop/james.txt");
        Count(file);
    }
}
