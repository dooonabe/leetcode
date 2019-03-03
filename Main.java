package com.dooonabe;

import com.dooonabe.sort.KthLargestElementInAnArray;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] nums = {1};
        int ret = new KthLargestElementInAnArray().findKthLargest(nums, 1);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
