package com.dooonabe.collection.array;

/**
 * 238. Product(乘积) of Array Except Self
 * 1. constant space complexity 2.O(n) 3.Not division
 * Created on 2019/2/24.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for(int index = 0 ; index<nums.length;index++){
            output[index] = 1;
        }
        int left = 1; int right = 1;
        for(int index = 0 ; index<nums.length;index++){
            output[index] *=left;
            left *=nums[index];
        }
        for(int index = nums.length-1 ; index > -1;index--){
            output[index] *=right;
            right *=nums[index];
        }
        return output;
    }
}
