package com.dooonabe.collection.array;

/**
 * 88. Merge Sorted Array
 * directly use insertion sort
 * Created on 2019/3/9.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int index = m + i -1;
            while (index >=0 && nums1[index] > nums2[i]){
                nums1[index + 1] = nums1[index];
                index -=1;
            }
            nums1[index+1] = nums2[i];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        new MergeSortedArray().merge(nums1,1,nums2,1);
    }

}
