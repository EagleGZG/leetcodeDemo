package com.wuj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Zconvert <br/>
 * Description: <br/>
 * date: 2020/8/14 2:56 下午<br/>
 *
 * @author ggj<br />
 * @since JDK 1.8
 */
public class Zconvert {


    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0){
            return s;
        }
        char [] chars = s.toCharArray();

        boolean isAdd = true;
        String [][] convertChars = new String[chars.length][chars.length];
        int newColumn = 0;
        int newRow = 0;
        for(char c : chars){
            convertChars[newRow][newColumn] = c+"";

            if(numRows == 1){
                newColumn = newColumn + 1;
                continue;
            }

            if(isAdd){
                newRow = newRow + 1;
            }else{
                newRow = newRow - 1;
                newColumn = newColumn + 1;
            }

            if( newRow >=numRows ){
                isAdd = false;
                newRow = newRow -2;
                newColumn = newColumn +1;
            }

            if(newRow == 0){
                isAdd = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i< chars.length;i++){
            for(int j = 0;j < chars.length; j++ ){
                if(convertChars[i][j] != null && !"".equals(convertChars[i][j])){
                    sb.append(convertChars[i][j]);
                }
            }
        }
        for(int i = 0;i< chars.length;i++) {
            for (int j = 0; j < chars.length; j++) {
                if(convertChars[i][j] == null){
                    System.out.print(" ");
                }else{
                    System.out.print(convertChars[i][j]);
                }
            }
            System.out.println();
        }

        return sb.toString();

    }
    public static String convert2(String s, int numRows) {
        if(s == null || "".equals(s) || numRows == 1){
            return s;
        }

        int line = 0;
        boolean flag = true;
        List<StringBuilder> builderList = new ArrayList<>(numRows);

        for(int i = 0; i < numRows; i++) {
            builderList.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();
        for(char c : chars){
            StringBuilder sb = builderList.get(line);
            sb.append(c);

            if(flag){
                line = line + 1;
            }else{
                line = line - 1;
            }
            if(line == (numRows-1)){
                flag = false;
            }

            if(line == 0){
                flag = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            StringBuilder stringBuilder = builderList.get(i);
            result.append(stringBuilder);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = convert("A",1);
        System.out.println(s);


    }
}
