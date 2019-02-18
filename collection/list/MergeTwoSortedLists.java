package com.dooonabe.collection.list;

/**
 * 21. Merge Two Sorted Lists
 * Created on 2019/2/18.
 */
public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode startNode = null;
        ListNode endNode = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        startNode = l1;
        while (l2 != null) {
            int val = l2.val;
            //insert
            startNode = insertNode(val, startNode);
            l2 = l2.next;
        }

        return startNode;
    }

    private ListNode insertNode(int value, ListNode node) {
        ListNode start = node;
        ListNode last = null;
        ListNode current = node;
        if (value >= current.val) {
            if (current.next != null) {
                if (value > current.next.val) {
                    // recursion
                    insertNode(value, current.next);
                } else {
                    //insert
                    ListNode next = current.next;
                    ListNode now = new ListNode(value);
                    now.next = next;
                    current.next = now;
                }
            } else {
                current.next = new ListNode(value);
            }
        } else {
            ListNode now = new ListNode(value);
            now.next = node;
            start = now;

        }
        return start;
    }

    public ListNode anotherMergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = anotherMergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = anotherMergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
