package com.dooonabe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        int[] nums = {1};
//        int ret = new KthLargestElementInAnArray().findKthLargest(nums, 1);
//
//        String out = String.valueOf(ret);
//
//        System.out.print(out);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        recover(list);
        list.forEach(s -> {
            System.out.println(s);
        });



    }

    private static void recover(List result) {
        result.add(0, "100");
        result.remove("1");
    }
}
