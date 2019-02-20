package com.dooonabe.collection.array;

/**
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * xor
 * Created on 2019/2/20.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums){
            result ^=num;
        }
        return result;
    }

}
