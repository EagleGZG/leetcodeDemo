package com.wuj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyi
 */
public class MaxLenthOfSubString {

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || "".equals(s)){
            return 0;
        }

        int length = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            Character character = s.charAt(i);
            if(map.get(character) != null){
                start = Math.max(map.get(character) + 1,start);
            }
            map.put(character,i);
            length = Math.max(length,i -start + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("abba");
        System.out.println("长度为：" + length);
    }
}
