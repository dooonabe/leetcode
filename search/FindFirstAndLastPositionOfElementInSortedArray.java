package com.dooonabe.search;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @date 2020/4/21 17:14
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        return new int[]{findStart(nums, target),findEnd(nums, target)};


    }

    private int findEnd(int[] nums, int target) {
        int head = 0, tail = nums.length - 1;
        int end = -1;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    end = mid;
                }
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        return end;
    }

    private int findStart(int[] nums, int target) {
        int head = 0, tail = nums.length - 1;
        int start = -1;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    start = mid;
                }
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return start;
    }
}
