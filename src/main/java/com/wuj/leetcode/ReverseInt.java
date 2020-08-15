package com.wuj.leetcode;

import java.nio.charset.Charset;
import javax.net.ssl.CertPathTrustManagerParameters;

/**
 * ClassName: ReverseInt <br/>
 * Description:
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * date: 2020/8/15 2:20 下午<br/>
 *
 * @author ggj<br />
 * @since JDK 1.8
 */
public class ReverseInt {

    public static int reverse(int x) {

        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }
        boolean bigThanZero = true;
        String s = Integer.toString(x);
        if(s.startsWith("-")){
            s = s.substring(1);
            bigThanZero = false;
        }
        StringBuilder result = new StringBuilder();
        if(!bigThanZero){
            result.append("-");
        }
        int length = s.length();
        char [] chars = s.toCharArray();
        for(int i = length-1; i >= 0;i--){
            result.append(chars[i]);
        }
        int resultInt = 0;
        try{
            resultInt = Integer.valueOf(result.toString());
        }catch (Exception e){

        }
        return resultInt;
    }

    public static int reverseV2(int x) {
        int result = 0;

        while(x != 0){

            int end = x % 10;
            x = x / 10;

            if(result > (Integer.MAX_VALUE/10) || ((result == Integer.MAX_VALUE/10) && end > 7)){
                return 0;
            }

            if(result < (Integer.MIN_VALUE/10) || ((result == Integer.MIN_VALUE/10) && end <-8)){
                return 0;
            }
            result = result*10 + end;

        }
        return result;
    }

    public static void main(String[] args) {

        int a = 1534236469;

        System.out.println(reverse(a));
        System.out.println(reverseV2(a));
    }
}
