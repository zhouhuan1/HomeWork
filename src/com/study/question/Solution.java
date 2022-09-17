package com.study.question;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] =new int[2];
        int left,right;
        boolean flag=false;
        left=0;
        right=1;
        while (true){
            while (left<right&& right<nums.length){
                if(nums[left]+nums[right]==target){
                    flag=true;
                    break;
                }
                right++;
            }
            if (flag){
                break;
            }
            left++;
        }
        result[0]=left;
        result[1]=right;
        return result;
    }
}
