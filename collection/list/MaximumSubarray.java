package com.dooonabe.collection.list;

/**
 * 53. Maximum Subarray
 * Created on 2019/2/18.
 */
public class MaximumSubarray {
    public static void main(String[] args) throws Exception {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i + 1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }



    public int anotherMaxSubArray(int[] nums){
        int start = 0;
        int length = 0;
        // sum
        int sum = nums[0];
        for(int i = 0 ;i<nums.length; i++){
            int value = nums[i];
            if(value>=sum){
                sum = value;
                start =i;
                length = 0;
            }
            for(int j =i+1 ;j<nums.length;j++){
                value+=nums[j];
                if(value>=sum){
                    sum = value;
                    start =i;
                    length = j-i;
                }
            }
        }
        // System.out.println("start:"+ start + " length:" + length);
        return sum;
    }
}
