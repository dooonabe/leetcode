package com.dooonabe.collection.array;

/**
 * Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * @date 2020/3/15 10:58
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result;
        if (nums == null || nums.length == 0) {
            result = new int[0];
        }
        result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sum + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}

