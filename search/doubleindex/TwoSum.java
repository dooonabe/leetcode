package com.dooonabe.search.doubleindex;

import java.util.Arrays;

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
    // 双指针
    public int[] searchRange(int[] nums, int target) {

        int[] copyNums = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copyNums);
        int head = 0, tail = copyNums.length - 1;
        while (head < tail) {
            int value = copyNums[head] + copyNums[tail];
            if (value > target) {
                tail--;
            } else if (value < target) {
                head++;
            } else {
                break;
            }
        }
        int index = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (copyNums[head] == nums[i] || copyNums[tail] == nums[i]) {
                result[index] = i;
                index++;
                if (index > 1) {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        sum.searchRange(new int[]{2, 7, 11, 15}, 9);
    }
}

