package com.dooonabe.collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * @date 2020/3/15 12:20
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(Arrays.stream(nums1).mapToObj(num -> (int) num).collect(Collectors.toList()));
        mergedList.addAll(Arrays.stream(nums2).mapToObj(num -> (int) num).collect(Collectors.toList()));
        mergedList.sort(Integer::compareTo);
        int size = mergedList.size();
        if(size % 2 == 0){
            return (mergedList.get(size/2) + mergedList.get(size/2 - 1))/2.0;
        } else {
            return mergedList.get(size/2);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.printf("" + medianOfTwoSortedArrays.findMedianSortedArrays(nums1,nums2));;
    }
}
