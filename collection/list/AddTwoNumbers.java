package com.dooonabe.collection.list;

/**
 * Created on 2019/2/24.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode output = null;
        ListNode current = null;
        int value = 0;
        int addition = 0;
        value = l1.val + l2.val;
        if(value>=10){
            addition = value / 10;
            output = new ListNode(value%10);
        } else{
            addition = 0;
            output = new ListNode(value);
        }
        current = output;
        int a ,b ;
        while (l1.next != null || l2.next != null){
            if(l1.next == null){
                a = 0;
                l2 = l2.next;
                b = l2.val;
            } else if(l2.next == null){
                b = 0;
                l1 = l1.next;
                a = l1.val;
            } else {
                l1 = l1.next;
                l2 = l2.next;
                a = l1.val;
                b = l2.val;
            }
            value = a + b + addition;
            if(value>=10){
                addition = value / 10;
                current.next = new ListNode(value%10);
            } else{
                addition = 0;
                current.next = new ListNode(value);
            }
            current = current.next;
        }

        if(addition!=0){
            current.next = new ListNode(addition);
        }

        return output;
    }
}
