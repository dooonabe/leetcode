package com.dooonabe.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 142. Linked List Cycle II
 * Can you solve it using O(1) (i.e. constant) memory?
 * Created on 2019/2/27.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        return null;
    }

    public ListNode anotherHasCycle(ListNode head) {
        if (head == null) return null;
        List list = new ArrayList();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            } else {
                list.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
