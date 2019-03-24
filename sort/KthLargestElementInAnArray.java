package com.dooonabe.sort;

/**
 * 215. Kth Largest Element in an Array
 * compare time && exchange time
 * Created on 2019/3/1.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int[] result = mergeSort(nums);
        return result[k - 1];
    }

    /**
     * Bubble Sort
     *
     * @param nums input
     * @return result
     */
    private int[] bubleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

        }
        return nums;
    }

    /**
     * selection sort reduce the exchange times
     *
     * @param nums input
     * @return result
     */
    private int[] selectionSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int max = nums[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return nums;
    }

    /**
     * Insertion Sort
     * copy time vs exchange time
     *
     * @param nums input
     * @return result
     */
    private int[] insertionSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int index = i;
            int value = nums[i];
            while (index >= 1 && value > nums[index - 1]) {
                // copy?exchange? i don't know
                nums[index] = nums[index - 1];
                index -= 1;
            }
            nums[index] = value;
        }
        return nums;
    }


    /**
     * merge-sort just needs O(N*logN) , upon three sorts al need O(N^2). yes you are right this al needs more memory spaces
     *
     * @param nums input
     * @return reslt
     */
    private int[] mergeSort(int[] nums) {
        int length = nums.length;
        int aLength = (length + 1) / 2;
        int bLength = length - aLength;
        int[] aNums = new int[aLength];
        int[] bNums = new int[bLength];
        if (aLength >= 3) {
            System.arraycopy(nums, 0, aNums, 0, aLength);
            aNums = mergeSort(aNums);
        } else if (aLength == 2) {
            if (nums[0] > nums[1]) {
                aNums[0] = nums[0];
                aNums[1] = nums[1];
            } else {
                aNums[0] = nums[1];
                aNums[1] = nums[0];
            }
        } else if (aLength == 1) {
            aNums[0] = nums[0];
        } else {

        }

        if (bLength >= 3) {
            System.arraycopy(nums, aLength, bNums, 0, bLength);
            bNums = mergeSort(bNums);
        } else if (bLength == 2) {
            if (nums[aLength] > nums[aLength + 1]) {
                bNums[0] = nums[aLength];
                bNums[1] = nums[aLength + 1];
            } else {
                bNums[0] = nums[aLength + 1];
                bNums[1] = nums[aLength];
            }

        } else if (bLength == 1) {
            bNums[0] = nums[aLength];
        } else {

        }


        return mergeTwoArray(aNums, bNums);
    }

    /**
     * merge sort two sorted arrays
     *
     * @param aNums a array
     * @param bNums b array
     * @return result
     */
    private int[] mergeTwoArray(int[] aNums, int[] bNums) {
        int[] result = new int[aNums.length + bNums.length];
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        while (aIndex < aNums.length && bIndex < bNums.length) {
            if (aNums[aIndex] > bNums[bIndex]) {
                result[index] = aNums[aIndex];
                aIndex++;
            } else {
                result[index] = bNums[bIndex];
                bIndex++;
            }
            index++;
        }

        if (aIndex < aNums.length) {
            for (int i = aIndex; i < aNums.length; i++) {
                result[index] = aNums[i];
                index++;
            }
        }

        if (bIndex < bNums.length) {
            for (int i = bIndex; i < bNums.length; i++) {
                result[index] = bNums[i];
                index++;
            }
        }
        return result;
    }


    /**
     * todo quick sort 20190311
     *
     * @param nums input
     * @return result
     */
    private int[] quickSort(int[] nums) {
        return null;
    }
}
