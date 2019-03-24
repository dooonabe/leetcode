package com.dooonabe;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Main implements Serializable {

    private static final long serialVersionUID = 1097638794031561660L;

    public static void main(String[] args) throws IOException {
//        int[] nums = {1};
//        int ret = new KthLargestElementInAnArray().findKthLargest(nums, 1);
//
//        String out = String.valueOf(ret);
//
//        System.out.print(out);
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        recover(list);
//        list.forEach(s -> {
//            System.out.println(s);
//        });
//        List<String> list1 = new ArrayList<>(Collections.nCopies(4, "hhhh"));
//        Collections.fill(list, "kkkkk");
        Collection collection = new HashSet();collection.add("aaa");
        LinkedHashSet set = new LinkedHashSet<String>(collection);
        Map map  = null;
        Iterable iterable =  map.entrySet();
    }

    private static void recover(List result) {
        result.add(0, "100");
        result.remove("1");
    }
}
