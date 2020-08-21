package com.wuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ThreeSum <br/>
 * Description:
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * date: 2020/8/20 10:33 上午<br/>
 *
 * @author ggj<br />
 * @since JDK 1.8
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return null;
        }

        boolean containsZero= false;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    boolean isContains = false;
                    if((nums[i] + nums[j] + nums[k]) == 0){

                        if(!containsZero && nums[i] == 0 && nums[j] == 0 && nums[k] == 0){
                            containsZero = true;
                            List<Integer> result = new ArrayList<>();
                            result.add(nums[i]);
                            result.add(nums[j]);
                            result.add(nums[k]);
                            list.add(result);
                            break;
                        }
                        for(List<Integer> tmp : list){
                            if(tmp.contains(nums[i]) && tmp.contains(nums[j]) && tmp.contains(nums[k])
                            ){
                                    isContains = true;
                                    break;
                            }
                        }
                        if(!isContains){
                            List<Integer> result = new ArrayList<>();
                            result.add(nums[i]);
                            result.add(nums[j]);
                            result.add(nums[k]);
                            list.add(result);
                        }

                    }
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int n = nums.length -1;
            for(int j = i+1;j < nums.length;j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                while(j < n && (nums[j] + nums[n]) > target){
                    n = n-1;
                }

                if(n == j){
                    break;
                }
                if(nums[j] + nums[n] == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[n]);
                    ans.add(tmp);
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }

}
