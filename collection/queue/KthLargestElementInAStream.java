package com.dooonabe.collection.queue;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream.
 * For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * @date 2020/3/16 14:39
 */
public class KthLargestElementInAStream {
    private final PriorityQueue<Integer> queue;
    private final int kthLargest;

    public KthLargestElementInAStream(int k, int[] nums) {
        kthLargest = k;
        queue = new PriorityQueue(k);
        for (int num : nums) {
            queue.add(num);
        }
    }

    public synchronized int add(int val) {
        if (queue.size() < kthLargest) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {12,5,7,8};
        KthLargestElementInAStream kthLargestElementInAStream = new KthLargestElementInAStream(1,nums);
    }


}
