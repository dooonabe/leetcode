package com.dooonabe.search.doubleindex;

/**
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * Don't use for
 *
 * @date 2020/4/19 16:43
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k <= 0) return 0;
        int count = 0;
        int nowValue = 1;
        for (int head = 0, tail = 0; tail < nums.length; tail++) {
            nowValue *= nums[tail];
            while (nowValue >= k) {
                nowValue = nowValue / nums[head];
                head++;
            }
            // or use for for get the Combination number
            count += tail - head + 1;
        }
        return count;
    }
}
