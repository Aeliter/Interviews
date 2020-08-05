package com.aeliter.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-06-29 11:12
 * @version: V1.0
 */
public class MinimumWindowsSunstringSolution {

    // Assumption: s and t are both not null
    public static String minWindow(String s, String t) {
        // corner case
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> wordDict = constructWordDict(t);
        int matchCnt = 0, index = 0, minLen = Integer.MAX_VALUE, slow = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            Integer count = wordDict.get(ch);
            if (count == null) {
                continue;
            }
            wordDict.put(ch, count - 1);
            // match another character
            if (count == 1) {
                matchCnt++;
            }
            while (matchCnt == wordDict.size()) {
                // find a valid substring
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                char leftmost = s.charAt(slow++);
                Integer leftmostCount = wordDict.get(leftmost);
                if (leftmostCount == null) {
                    continue;
                }
                wordDict.put(leftmost, leftmostCount + 1);
                if (leftmostCount == 0) {
                    // 0 -> 1
                    matchCnt--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }

    private static Map<Character, Integer> constructWordDict(String t) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }

}
