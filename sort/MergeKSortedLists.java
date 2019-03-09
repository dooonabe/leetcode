package com.dooonabe.sort;

import com.dooonabe.collection.list.ListNode;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list.
 * Created on 2019/3/7.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        //priorityqueue
        PriorityQueue<Integer> queue = new PriorityQueue<>(100);
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while (!queue.isEmpty()) {
            if (head == null) {
                head = new ListNode(queue.poll());
                tail = head;
            } else {
                ListNode element = new ListNode(queue.poll());
                tail.next = element;
                tail = element;
            }
        }
        return head;
    }

    /**
     * recursive
     *
     * @param lists input
     * @return result
     */
    public ListNode anotherMergeLists(ListNode[] lists) {
        ListNode head = null;
        for (int index = 0; index + 1 < lists.length; index++) {
            if (head != null) {
                head = mergeTwoLists(head, lists[index + 1]);

            } else {
                head = mergeTwoLists(lists[index], lists[index + 1]);

            }
        }
        head = mergeTwoLists(head, lists[lists.length - 1]);
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(17);
        ListNode node2 = new ListNode(11);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(11);
        ListNode node5 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode[] array = new ListNode[]{node1, node11};
        System.out.println(new MergeKSortedLists().anotherMergeLists(array).val);
    }
}
