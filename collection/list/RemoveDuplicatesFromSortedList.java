package com.dooonabe.collection.list;

/**
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Created on 2019/2/18.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        // null
        if (head == null) return head;
        else {
            while (current.next != null) {
                if (current.val == current.next.val) {
                    //del node
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return head;
        }
    }
}
