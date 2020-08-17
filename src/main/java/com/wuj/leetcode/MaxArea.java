package com.wuj.leetcode;

/**
 * ClassName: MaxArea <br/>
 * Description:
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * date: 2020/8/17 1:43 下午<br/>
 *
 * @author ggj<br />
 * @since JDK 1.8
 */
public class MaxArea {

    public static  int maxArea(int[] height){

        if(height == null || height.length == 0){
            return 0;
        }
        int area = 0;
        int length = height.length;
        int i = 0;
        int j = length - 1;

        while (i < j){
            area = Integer.max((j-i)*Integer.min(height[i],height[j]),area);
            if(height[i] >= height[j]){
                j = j-1;
            }else{
                i = i+1;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int a[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
