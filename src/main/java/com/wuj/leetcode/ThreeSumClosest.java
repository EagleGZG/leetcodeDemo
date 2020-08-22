package com.wuj.leetcode;

import java.util.Arrays;

/**
 * ClassName: ThreeSumClosest <br/>
 * Description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^

 * date: 2020/8/22 10:58 上午<br/>
 *
 * @author ggj<br />
 * @since JDK 1.8
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3){
            return nums[0] + nums[1] + nums[2];
        }
        int ans = nums[0] + nums[1] + nums[2];
        int min =target - (nums[0] + nums[1] + nums[2]);
        if(min < 0){
            min = -min;
        }
        for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j <nums.length; j++){
                for(int k = j+1; k <nums.length; k++){
                    int tmp = target - (nums[i] + nums[j] + nums[k]);
                    if(tmp < 0){
                        tmp = -tmp;
                    }
                    if(tmp < min){
                        ans = nums[i] + nums[j] + nums[k];
                        min = tmp;
                    }
                }
            }
        }

        return ans;
    }


    public static int threeSumClosest2(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            int end = nums.length -1;
            while (j < end){

                int sum = nums[i] + nums[j] + nums[end];
                if(sum == target){
                    return target;
                }

                if(Math.abs(target - ans) > Math.abs(target - sum)){
                    ans = sum;
                }
                if(target - sum > 0){
                    j = j+1;
                }else{
                    end = end -1;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
