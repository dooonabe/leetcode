package com.dooonabe.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 141. Linked List Cycle
 * Can you solve it using O(1) (i.e. constant) memory?
 * Created on 2019/2/27.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null && head.next == null) return false;

        return false;
    }


    public boolean anotherHasCycle(ListNode head){
        if(head == null) return false;
        List list = new ArrayList();
        while (head != null){
            if(list.contains(head)){
                return true;
            } else {
                list.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
