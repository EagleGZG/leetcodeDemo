package com.wuj.leetcode;

/**
 * ClassName: longestPalindrome <br/>
 * Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author xiaoyi<br />
 * @since JDK 1.8
 */
public class LongestPalindrome {


    public static String longestPalindrome(String s) {

        //用于获取字符
        char cArray[] = s.toCharArray();

        //length = 1
        if(s.length() < 2){
            return s;
        }

        //length = 2
        if(s.length() == 2){
            if(cArray[0] == cArray[1]){
                return s;
            }
            return s.substring(0,1);
        }
        int start = 0;
        int maxLength = 1;


        //length >2
        //用户判断回文
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for(int j = 0; j < s.length();j++){
            for(int i = 0;i <= j;i++){
                if(i == j){
                    isPalindrome[i][j] = true;
                    continue;
                }
                if((cArray[i] == cArray[j])){
                    if((j-i < 3) ||  isPalindrome[i + 1][j - 1]){
                        isPalindrome[i][j] = true;
                        if( (j-i +1) > maxLength){
                            maxLength = j - i + 1;
                            start = i;
                        }
                    }else{
                        isPalindrome[i][j] = false;
                    }
                }
            }
        }

        return s.substring(start,maxLength + start);
    }

    public static void main(String[] args) {
        String s = longestPalindrome("aa");
        System.out.println(s);

    }

}
