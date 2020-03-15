package com.dooonabe.collection.array;

/**
 * 53. Maximum Subarray
 * Created on 2019/2/18.
 */
public class MaximumSubarray {
    /**
     * 分治算法，分：递归，治：原问题的解。
     * 递归函数的参数一般为：传递输入的数组以及左边界，右边界。
     * O(NlogN)
     *
     * @param nums array
     * @return count
     */
    public int DivideAndConquerMaxSubArray(int[] nums) {
        return maxSubSum(nums, 0, nums.length - 1);
    }

    /**
     * @param nums  数组
     * @param left  左边界
     * @param right 有边界
     */
    private int maxSubSum(int[] nums, int left, int right) {
        // 特殊情况
        if (left == right) {
            return nums[left];
        }

        int maxLeftSum, maxRightSum;
        int center = (left + right) / 2;
        maxLeftSum = maxSubSum(nums, left, center);
        maxRightSum = maxSubSum(nums, center + 1, right);


        // 边界值
        int maxLeftBorderSum = nums[center];
        int leftBorderSum = nums[center];
        for (int i = center - 1; i >= left; i--) {
            leftBorderSum += nums[i];
            maxLeftBorderSum = Math.max(maxLeftBorderSum, leftBorderSum);
        }

        int maxRightBorderSum = nums[center + 1];
        int rightBorderSum = nums[center + 1];
        for (int i = center + 2; i <= right; i++) {
            rightBorderSum += nums[i];
            maxRightBorderSum = Math.max(maxRightBorderSum, rightBorderSum);
        }
        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }


    /**
     * O(N2)
     *
     * @param nums array
     * @return count
     */
    public int commonMaxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int thisSum = nums[i];
            sum = Math.max(sum, thisSum);
            for (int j = i + 1; j < nums.length; j++) {
                thisSum += nums[j];
                sum = Math.max(sum, thisSum);
            }
        }
        return sum;
    }
}
