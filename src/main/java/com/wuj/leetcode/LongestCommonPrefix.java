package com.wuj.leetcode;

/**
 * ClassName: LongestCommonPrefix <br/>
 * Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * date: 2020/8/19 9:58 上午<br/>
 *
 * @author ggj<br />
 * @since JDK 1.8
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs.length;
        int rowLength = strs[0].length();

        for(int j=0; j < rowLength; j++){
            char c = strs[0].charAt(j);
            for(int i = 1; i<length ;i++){
                if(j == strs[i].length() || c != strs[i].charAt(j)){
                    return  strs[0].substring(0,j);
                }
            }
        }


        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }

}
