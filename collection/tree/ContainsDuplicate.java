package com.dooonabe.collection.tree;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * @date 2020/4/18 20:10
 */
public class ContainsDuplicate {

    public boolean containsNearbyAlmostDuplicateAnother(int[] nums, int k, int t) {
        // 防止溢出
        long[] input = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            input[i] = nums[i];
        }
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((j - i) <= k && Math.abs(input[j] - input[i]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 滑动窗口(treeset)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1) return false;

        TreeSet<Integer> windows = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // ceiling 天花板
            Integer ceil = windows.ceiling(nums[i]);
            if (ceil != null && Math.abs((long) nums[i] - (long) ceil) <= t) {
                return true;
            }

            // floor 地板
            Integer floor = windows.floor(nums[i]);
            if (floor != null && Math.abs((long) floor - (long) nums[i]) <= t) {
                return true;
            }

            windows.add(nums[i]);
            if (windows.size() >= k + 1) {
                windows.remove(nums[i - k]);
            }
        }
        return false;
    }
}
